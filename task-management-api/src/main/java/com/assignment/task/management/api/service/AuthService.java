package com.assignment.task.management.api.service;

import com.assignment.task.management.api.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse getLoggedUser(String userName,String password);
}
