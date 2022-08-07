package com.bugraburunguz.leavemanagementservice.validation.impl;

import com.bugraburunguz.leavemanagementservice.dto.UserDto;
import com.bugraburunguz.leavemanagementservice.entity.UserEntity;
import com.bugraburunguz.leavemanagementservice.repository.UserRepository;
import com.bugraburunguz.leavemanagementservice.validation.UserAdminService;
import com.bugraburunguz.leavemanagementservice.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserAdminAdminServiceImpl implements UserAdminService {

    private final UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setRole(userDto.getRole());
        userEntity.setDateOfRecruitment(userDto.getDateOfRecruitment());
        int dateOfLeave = DateUtil.calculateRightOfLeavesDay(userEntity.getDateOfRecruitment());
        userEntity.setRightOfLeave(dateOfLeave);
        userRepository.save(userEntity);
        return userDto;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> userListRepository = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        userListRepository.forEach(it -> {
            UserDto userDto = new UserDto();
            userDto.setId(it.getId());
            userDto.setFirstName(it.getFirstName());
            userDto.setLastName(it.getLastName());
            userDto.setRole(it.getRole());
            userDto.setDateOfRecruitment(it.getDateOfRecruitment());
            userDto.setRightOfLeave(it.getRightOfLeave());

            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return null;
    }
}
