package com.bugraburunguz.leavemanagementservice.request;

import com.bugraburunguz.leavemanagementservice.enums.LeaveStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class LeaveRequest implements Serializable {

    private LeaveStatus leaveStatus = LeaveStatus.HOLD;

    private String leaveReason;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long userId;

}
