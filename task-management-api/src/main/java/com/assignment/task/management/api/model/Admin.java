package com.assignment.task.management.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {
    @Id
    @Column(name = "admin_id",length = 60)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @Column(name = "admin_name",length = 150,nullable = false)
    private String adminName;

    @Column(name = "admin_password",length = 12,nullable = false)
    private String adminPassword;
}
