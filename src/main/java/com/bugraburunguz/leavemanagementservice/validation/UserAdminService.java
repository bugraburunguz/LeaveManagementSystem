package com.bugraburunguz.leavemanagementservice.validation;

import com.bugraburunguz.leavemanagementservice.request.UserRequest;
import com.bugraburunguz.leavemanagementservice.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserAdminService {
    Long create(UserRequest userRequest) throws Exception;

    void delete(Long id);

    void update(UserRequest userRequest, Long userId);

    List<UserResponse> findAll();

    Page<UserResponse> findAll(Pageable pageable);
}