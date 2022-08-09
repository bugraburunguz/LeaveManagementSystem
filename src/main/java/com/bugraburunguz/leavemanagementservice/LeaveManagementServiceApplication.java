package com.bugraburunguz.leavemanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LeaveManagementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeaveManagementServiceApplication.class, args);
    }
}
