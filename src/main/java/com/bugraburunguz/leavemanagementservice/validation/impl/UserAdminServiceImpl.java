package com.bugraburunguz.leavemanagementservice.validation.impl;

import com.bugraburunguz.leavemanagementservice.entity.UserEntity;
import com.bugraburunguz.leavemanagementservice.repository.UserAdminRepository;
import com.bugraburunguz.leavemanagementservice.request.UserRequest;
import com.bugraburunguz.leavemanagementservice.response.UserResponse;
import com.bugraburunguz.leavemanagementservice.util.DateUtil;
import com.bugraburunguz.leavemanagementservice.validation.UserAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAdminServiceImpl implements UserAdminService {

    private final UserAdminRepository userAdminRepository;

    @Override
    public Long create(UserRequest userRequest) {

        UserEntity userEntity = new UserEntity();
        UserEntity userEntity1 = populateUserEntity(userRequest, userEntity);
        UserEntity lastSavedBanner = userAdminRepository.save(userEntity1);
        userAdminRepository.save(userEntity);
        return lastSavedBanner.getId();
    }

    private UserEntity populateUserEntity(UserRequest userRequest, UserEntity userEntity) {

        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setRole(userRequest.getRole());
        userEntity.setDateOfRecruitment(userRequest.getDateOfRecruitment());
        userEntity.setRightOfLeaveDay(DateUtil.calculateRightOfLeavesDay(userRequest.getDateOfRecruitment()));
        return userEntity;
    }

    @Override
    public void delete(Long id) {
        userAdminRepository.deleteById(id);
    }

    @Override
    public void update(UserRequest userRequest, Long userId) {
        UserEntity userEntity = userAdminRepository.findById(userId).orElseThrow(RuntimeException::new);
        populateUserEntity(userRequest, userEntity);
        userAdminRepository.save(userEntity);
    }


    @Override
    public List<UserResponse> findAll() {
        List<UserEntity> userListRepository = userAdminRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        userListRepository.forEach(it -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(it.getId());
            userResponse.setFirstName(it.getFirstName());
            userResponse.setLastName(it.getLastName());
            userResponse.setRole(it.getRole());
            userResponse.setRightOfLeaveDay(it.getRightOfLeaveDay());
            userResponse.setDateOfRecruitment(it.getDateOfRecruitment());

            userResponseList.add(userResponse);
        });
        return userResponseList;
    }

    @Override
    public Page<UserResponse> findAll(Pageable pageable) {
        return null;
    }
}
