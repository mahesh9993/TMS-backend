package com.assignment.task.management.api.controller;

import com.assignment.task.management.api.dto.UserDTO;
import com.assignment.task.management.api.dto.request.UserUpdateRQ;
import com.assignment.task.management.api.dto.response.UserResponseDTO;
import com.assignment.task.management.api.service.UserService;
import com.assignment.task.management.api.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<StandardResponse> addUser(@RequestBody UserDTO userDTO){
        String response = this.userService.addUser(userDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"User Created",response), HttpStatus.CREATED
        );
    }

    @GetMapping("/users")
    public ResponseEntity<StandardResponse> getAllUsers(){
        List<UserResponseDTO> userDTOList = this.userService.getAllUsers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Users",userDTOList), HttpStatus.OK
        );
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<StandardResponse> getUserById(@PathVariable(value = "id") int id){
        UserResponseDTO userResponse = this.userService.getUser(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"User Details",userResponse), HttpStatus.OK
        );
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<StandardResponse> deleteUser(@PathVariable(value = "id") int id){
        String response = this.userService.deleteUser(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"User deleted",response), HttpStatus.OK
        );
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<StandardResponse> updateUser(@PathVariable(value = "id") int id,
                                                       @RequestBody UserUpdateRQ userUpdateRQ){
        String response = this.userService.updateUser(id,userUpdateRQ);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"User Updated",response), HttpStatus.OK
        );
    }

}
