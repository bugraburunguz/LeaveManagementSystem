package com.bugraburunguz.leavemanagementservice.validation;

import com.bugraburunguz.leavemanagementservice.dto.UserDto;
import com.bugraburunguz.leavemanagementservice.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserAdminService {
    UserDto create(UserDto userDto);

    public void delete(Long id);

    void update(Long id);

    List<UserDto> findAll();

    Page<UserDto> findAll(Pageable pageable);
}