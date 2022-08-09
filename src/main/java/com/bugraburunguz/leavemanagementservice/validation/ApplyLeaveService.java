package com.bugraburunguz.leavemanagementservice.validation;

import com.bugraburunguz.leavemanagementservice.request.LeaveRequest;
import com.bugraburunguz.leavemanagementservice.response.LeaveResponse;

import java.util.List;

public interface ApplyLeaveService {
    Long create(LeaveRequest leaveRequest);

    void delete(Long id);

    void update(LeaveRequest leaveRequest, Long leaveId);

    List<LeaveResponse> findAll();
}
