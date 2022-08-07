package com.bugraburunguz.leavemanagementservice.validation;

import com.bugraburunguz.leavemanagementservice.dto.UserAdminDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserAdminService {
    UserAdminDto save(UserAdminDto userAdminDto);

    public void delete(Long id);

    void update(Long id);

    List<UserAdminDto> findAll();

    Page<UserAdminDto> findAll(Pageable pageable);
}