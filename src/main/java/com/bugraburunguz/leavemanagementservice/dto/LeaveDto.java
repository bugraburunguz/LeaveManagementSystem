package com.bugraburunguz.leavemanagementservice.dto;

import com.bugraburunguz.leavemanagementservice.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class LeaveDto implements Serializable {

    private Long id;

    private String leaveStatus;

    private String leaveReason;

    private LocalDate startDate;

    private LocalDate endDate;

    private UserEntity userId;

}
