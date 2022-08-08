package com.bugraburunguz.leavemanagementservice.repository;

import com.bugraburunguz.leavemanagementservice.entity.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyLeaveRepository extends JpaRepository<LeaveEntity, Long> {
    void deleteById(Long id);
}