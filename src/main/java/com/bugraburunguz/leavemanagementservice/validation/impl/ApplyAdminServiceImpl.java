package com.bugraburunguz.leavemanagementservice.validation.impl;

import com.bugraburunguz.leavemanagementservice.entity.LeaveEntity;
import com.bugraburunguz.leavemanagementservice.entity.UserEntity;
import com.bugraburunguz.leavemanagementservice.enums.LeaveStatus;
import com.bugraburunguz.leavemanagementservice.repository.ApplyLeaveRepository;
import com.bugraburunguz.leavemanagementservice.repository.UserAdminRepository;
import com.bugraburunguz.leavemanagementservice.request.LeaveRequest;
import com.bugraburunguz.leavemanagementservice.response.LeaveResponse;
import com.bugraburunguz.leavemanagementservice.util.DateUtil;
import com.bugraburunguz.leavemanagementservice.validation.ApplyLeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyAdminServiceImpl implements ApplyLeaveService {

    private final ApplyLeaveRepository applyLeaveRepository;
    private final UserAdminRepository userAdminRepository;

    @Override
    public Long create(LeaveRequest leaveRequest) {

        LeaveEntity leaveEntity = new LeaveEntity();
        LeaveEntity leaveEntity1 = populateLeaveEntity(leaveRequest, leaveEntity);
        LeaveEntity lastSavedBanner = applyLeaveRepository.save(leaveEntity1);
        applyLeaveRepository.save(leaveEntity);
        return lastSavedBanner.getId();
    }

    private LeaveEntity populateLeaveEntity(LeaveRequest leaveRequest, LeaveEntity leaveEntity) {

        UserEntity userEntity = userAdminRepository.findById(leaveRequest.getUserId()).orElseThrow(RuntimeException::new);
        leaveEntity.setStartDate(leaveRequest.getStartDate());
        leaveEntity.setEndDate(leaveRequest.getEndDate());
        leaveEntity.setLeaveStatus(leaveRequest.getLeaveStatus());
        leaveEntity.setLeaveReason(leaveRequest.getLeaveReason());
        leaveEntity.setUser(userEntity);
        leaveEntity.setDuration(DateUtil.toLeaveDuration(leaveRequest.getStartDate(), leaveRequest.getEndDate()));
        userEntity.setRightOfLeaveDay(userEntity.getRightOfLeaveDay() - leaveEntity.getDuration());
        Long userRemainingDay = userEntity.getRightOfLeaveDay() - leaveEntity.getDuration();
        if (leaveEntity.getDuration() > userRemainingDay) {
            throw new RuntimeException("The Employee cannot request more than his/her own leave right");
        }
        return leaveEntity;
    }

    @Override
    public void delete(Long id) {
        applyLeaveRepository.deleteById(id);
    }

    @Override
    public void update(LeaveRequest leaveRequest, Long leaveId) {
        LeaveEntity leaveEntity = applyLeaveRepository.findById(leaveId).orElseThrow(RuntimeException::new);

        populateLeaveEntity(leaveRequest, leaveEntity);
        applyLeaveRepository.save(leaveEntity);
    }

    @Override
    public List<LeaveResponse> findAll() {
        List<LeaveEntity> leaveListRepository = applyLeaveRepository.findAll();
        List<LeaveResponse> leaveResponseList = new ArrayList<>();
        leaveListRepository.forEach(it -> {
            LeaveResponse leaveResponse = new LeaveResponse();
            leaveResponse.setId(it.getId());
            leaveResponse.setLeaveReason(it.getLeaveReason());
            leaveResponse.setLeaveStatus(it.getLeaveStatus());
            leaveResponse.setStartDate(it.getStartDate());
            leaveResponse.setEndDate(it.getEndDate());
            leaveResponse.setUserId(it.getUser().getId());
            leaveResponse.setDuration(it.getDuration());
            leaveResponseList.add(leaveResponse);
        });
        return leaveResponseList;
    }

    @Override
    public Page<LeaveResponse> findAll(Pageable pageable) {
        return null;
    }
}
