package com.bugraburunguz.leavemanagementservice.dto;

import com.bugraburunguz.leavemanagementservice.entity.LeaveEntity;
import com.sun.org.apache.xml.internal.utils.SerializableLocatorImpl;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class UserDto implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String role;

    private LocalDate dateOfRecruitment;

    private Long leaveValuesId;

}
