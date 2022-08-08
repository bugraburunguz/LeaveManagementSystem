package com.bugraburunguz.leavemanagementservice.validation.impl;

import com.bugraburunguz.leavemanagementservice.dto.UserDto;
import com.bugraburunguz.leavemanagementservice.entity.LeaveEntity;
import com.bugraburunguz.leavemanagementservice.entity.UserEntity;
import com.bugraburunguz.leavemanagementservice.repository.ApplyLeaveRepository;
import com.bugraburunguz.leavemanagementservice.repository.UserAdminRepository;
import com.bugraburunguz.leavemanagementservice.validation.UserAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UserAdminServiceImpl implements UserAdminService {

    private final UserAdminRepository userAdminRepository;
    private final ApplyLeaveRepository applyLeaveRepository;

    @Override
    public UserDto create(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLeaveValuesId(getLeaveValues());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setRole(userDto.getRole());
        userEntity.setDateOfRecruitment(userDto.getDateOfRecruitment());
        userAdminRepository.save(userEntity);
        return userDto;
    }

    private LeaveEntity getLeaveValues() {
        UserEntity userEntity = new UserEntity();
        UserDto userDto = new UserDto();
        Long leaveValueId = Objects.nonNull(userDto.getLeaveValuesId())
                ? userDto.getLeaveValuesId() : userEntity.getLeaveValuesId().getId();
        LeaveEntity leaveEntity = null;
        try {
            leaveEntity = applyLeaveRepository.findById(leaveValueId).orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leaveEntity;
    }

    @Override
    public void delete(Long id) {
        userAdminRepository.deleteById(id);
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> userListRepository = userAdminRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        userListRepository.forEach(it -> {
            UserDto userDto = new UserDto();
            userDto.setId(it.getId());
            userDto.setFirstName(it.getFirstName());
            userDto.setLastName(it.getLastName());
            userDto.setRole(it.getRole());
            userDto.setDateOfRecruitment(it.getDateOfRecruitment());
            userDto.setLeaveValuesId(it.getLeaveValuesId().getId());

            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return null;
    }
}
