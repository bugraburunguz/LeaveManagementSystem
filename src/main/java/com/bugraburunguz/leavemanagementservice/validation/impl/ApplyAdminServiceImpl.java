package com.bugraburunguz.leavemanagementservice.validation.impl;

import com.bugraburunguz.leavemanagementservice.dto.LeaveDto;
import com.bugraburunguz.leavemanagementservice.dto.UserDto;
import com.bugraburunguz.leavemanagementservice.entity.LeaveEntity;
import com.bugraburunguz.leavemanagementservice.repository.ApplyLeaveRepository;
import com.bugraburunguz.leavemanagementservice.validation.ApplyLeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyAdminServiceImpl implements ApplyLeaveService {

    private final ApplyLeaveRepository applyLeaveRepository;


    @Override
    public LeaveDto create(LeaveDto leaveDto) {
        LeaveEntity leaveEntity = new LeaveEntity();
        leaveEntity.setUserId(leaveDto.getUserId());
        leaveEntity.setStartDate(leaveDto.getStartDate());
        leaveEntity.setEndDate(leaveDto.getEndDate());
        leaveEntity.setLeaveReason(leaveDto.getLeaveReason());
        leaveEntity.setLeaveStatus(leaveDto.getLeaveStatus());
        applyLeaveRepository.save(leaveEntity);
        return leaveDto;
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return null;
    }
}
