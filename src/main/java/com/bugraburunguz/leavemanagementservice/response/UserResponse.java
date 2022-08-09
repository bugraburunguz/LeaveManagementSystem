package com.bugraburunguz.leavemanagementservice.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
public class UserResponse implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String role;

    private LocalDate dateOfRecruitment;

    private Long rightOfLeaveDay;

}
