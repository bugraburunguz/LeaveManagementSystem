package com.bugraburunguz.leavemanagementservice.repository;

import com.bugraburunguz.leavemanagementservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    void deleteById(Long id);
}