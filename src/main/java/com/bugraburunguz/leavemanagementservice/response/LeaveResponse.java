package com.bugraburunguz.leavemanagementservice.response;

import com.bugraburunguz.leavemanagementservice.enums.LeaveStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class LeaveResponse implements Serializable {

    private Long id;

    private LeaveStatus leaveStatus=LeaveStatus.HOLD;

    private String leaveReason;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long duration;

    private Long userId;

}
