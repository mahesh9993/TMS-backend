package com.assignment.task.management.api.controller;

import com.assignment.task.management.api.dto.response.LoginResponse;
import com.assignment.task.management.api.service.AuthService;
import com.assignment.task.management.api.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/auth/{userName}/{password}")
    public ResponseEntity<StandardResponse> getLoggedUser(@PathVariable(value = "userName") String userName,
                                                          @PathVariable(value = "password") String password){
        LoginResponse loginResponse = this.authService.getLoggedUser(userName,password);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"User Authentication",loginResponse), HttpStatus.OK
        );
    }
}
