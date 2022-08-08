package com.bugraburunguz.leavemanagementservice.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_info")
public class LeaveEntity {

    @SequenceGenerator(name = "seq_user_info", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_info", strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String leaveStatus;

    @Column
    private String leaveReason;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_info_id")
    private UserEntity userId;
}
