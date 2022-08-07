package com.bugraburunguz.leavemanagementservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAdminDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String role;

    private LocalDate dateOfRecruitment;

    private int rightOfLeave;

}
