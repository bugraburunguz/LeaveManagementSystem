package com.bugraburunguz.leavemanagementservice.request;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
public class UserRequest implements Serializable {

    private String firstName;

    private String lastName;

    private String role;

    private LocalDate dateOfRecruitment;

    public static UserRequest builder() {
        return new UserRequest();
    }

}
