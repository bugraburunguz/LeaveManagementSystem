package com.bugraburunguz.leavemanagementservice.validation.impl;

import com.bugraburunguz.leavemanagementservice.dto.UserAdminDto;
import com.bugraburunguz.leavemanagementservice.entity.UserAdminEntity;
import com.bugraburunguz.leavemanagementservice.repository.UserAdminRepository;
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

    private final UserAdminRepository userAdminRepository;

    @Override
    public UserAdminDto save(UserAdminDto userAdminDto) {
        UserAdminEntity userAdminEntity = new UserAdminEntity();
        userAdminEntity.setFirstName(userAdminDto.getFirstName());
        userAdminEntity.setLastName(userAdminDto.getLastName());
        userAdminEntity.setRole(userAdminDto.getRole());
        userAdminEntity.setDateOfRecruitment(userAdminDto.getDateOfRecruitment());
        int dateOfLeave = DateUtil.calculateRightOfLeavesDay(userAdminEntity.getDateOfRecruitment());
        userAdminEntity.setRightOfLeave(dateOfLeave);
        userAdminRepository.save(userAdminEntity);
        return userAdminDto;
    }

    @Override
    public void delete(Long id) {
        userAdminRepository.deleteById(id);
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public List<UserAdminDto> findAll() {
        List<UserAdminEntity> userListRepository = userAdminRepository.findAll();
        List<UserAdminDto> userAdminDtos = new ArrayList<>();
        userListRepository.forEach(it -> {
            UserAdminDto userAdminDto = new UserAdminDto();
            userAdminDto.setId(it.getId());
            userAdminDto.setFirstName(it.getFirstName());
            userAdminDto.setLastName(it.getLastName());
            userAdminDto.setRole(it.getRole());
            userAdminDto.setDateOfRecruitment(it.getDateOfRecruitment());
            userAdminDto.setRightOfLeave(it.getRightOfLeave());

            userAdminDtos.add(userAdminDto);
        });
        return userAdminDtos;
    }

    @Override
    public Page<UserAdminDto> findAll(Pageable pageable) {
        return null;
    }
}
