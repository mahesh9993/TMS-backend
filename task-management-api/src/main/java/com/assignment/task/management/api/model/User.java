package com.assignment.task.management.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @Column(name = "user_id",length = 60)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name",length = 150,nullable = false)
    private String userName;

    @Column(name = "password",length = 12,nullable = false)
    private String password;

    @Column(name = "designation",length = 60,nullable = false)
    private String designation;

}
