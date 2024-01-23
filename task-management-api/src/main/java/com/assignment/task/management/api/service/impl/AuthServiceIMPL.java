package com.assignment.task.management.api.service.impl;

import com.assignment.task.management.api.dto.response.LoginResponse;
import com.assignment.task.management.api.exception.NotFoundException;
import com.assignment.task.management.api.model.Admin;
import com.assignment.task.management.api.model.User;
import com.assignment.task.management.api.repo.AdminRepo;
import com.assignment.task.management.api.repo.UserRepo;
import com.assignment.task.management.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceIMPL implements AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public LoginResponse getLoggedUser(String userName,String password) {

        if (userName.equals("SYSTEM")){
            Admin admin = this.adminRepo.findByAdminNameEqualsAndAdminPasswordEquals(userName,password);
            if (admin != null){
                LoginResponse loginResponse = new LoginResponse();

                loginResponse.setUserId(admin.getAdminId());
                loginResponse.setUserType("admin");

                return loginResponse;
            }else{
                throw new NotFoundException("Admin Not Found");
            }


        }else {
            User user = this.userRepo.findByUserNameAndPassword(userName,password);
            if (user != null){
                LoginResponse loginResponse = new LoginResponse();

                loginResponse.setUserId(user.getUserId());
                loginResponse.setUserType("user");

                return loginResponse;
            }else {
                throw new NotFoundException("User Not Found");
            }
        }

    }
}
