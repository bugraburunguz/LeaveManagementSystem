package com.bugraburunguz.leavemanagementservice.entity;

import com.bugraburunguz.leavemanagementservice.enums.LeaveStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "leave_info")
public class LeaveEntity {

    @SequenceGenerator(name = "seq_user_info", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_info", strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private LeaveStatus leaveStatus = LeaveStatus.HOLD;

    @Column
    private String leaveReason;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private Long duration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
