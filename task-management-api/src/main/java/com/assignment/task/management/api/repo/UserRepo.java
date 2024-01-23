package com.assignment.task.management.api.repo;

import com.assignment.task.management.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUserNameAndPassword(String userName, String password);
}
