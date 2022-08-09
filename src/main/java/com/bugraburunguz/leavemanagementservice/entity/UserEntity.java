package com.bugraburunguz.leavemanagementservice.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_info")
public class UserEntity implements Serializable {

    @SequenceGenerator(name = "seq_user_info", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_info", strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private LocalDate dateOfRecruitment;

    @Column
    private Long rightOfLeaveDay;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LeaveEntity> leaveValuesIdList = new ArrayList<>();
}
