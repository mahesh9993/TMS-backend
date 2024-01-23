package com.assignment.task.management.api.repo;

import com.assignment.task.management.api.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Integer> {
    Admin findByAdminNameEqualsAndAdminPasswordEquals(String adminName, String password);
}
