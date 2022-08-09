package com.bugraburunguz.leavemanagementservice.validation;

import com.bugraburunguz.leavemanagementservice.request.UserRequest;
import com.bugraburunguz.leavemanagementservice.response.UserResponse;

import java.util.List;

public interface UserAdminService {
    Long create(UserRequest userRequest) throws Exception;

    void delete(Long id);

    void update(UserRequest userRequest, Long userId);

    List<UserResponse> findAll();
}