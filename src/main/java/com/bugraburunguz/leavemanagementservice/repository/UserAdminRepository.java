package com.bugraburunguz.leavemanagementservice.repository;

import com.bugraburunguz.leavemanagementservice.entity.UserAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdminRepository extends JpaRepository<UserAdminEntity, Long> {
    void deleteById(Long id);
}