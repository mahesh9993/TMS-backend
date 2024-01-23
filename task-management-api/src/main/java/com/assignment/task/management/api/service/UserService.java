package com.assignment.task.management.api.service;

import com.assignment.task.management.api.dto.UserDTO;
import com.assignment.task.management.api.dto.request.UserUpdateRQ;
import com.assignment.task.management.api.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    String addUser(UserDTO userDTO);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUser(int id);

    String deleteUser(int id);

    String updateUser(int id,UserUpdateRQ userUpdateRQ);
}
