package com.bugraburunguz.leavemanagementservice.validation;

import com.bugraburunguz.leavemanagementservice.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserAdminService {
    UserDto save(UserDto userDto);

    public void delete(Long id);

    void update(Long id);

    List<UserDto> findAll();

    Page<UserDto> findAll(Pageable pageable);
}