package com.assignment.task.management.api.service.impl;

import com.assignment.task.management.api.dto.UserDTO;
import com.assignment.task.management.api.dto.request.UserUpdateRQ;
import com.assignment.task.management.api.dto.response.UserResponseDTO;
import com.assignment.task.management.api.exception.NotFoundException;
import com.assignment.task.management.api.model.User;
import com.assignment.task.management.api.repo.UserRepo;
import com.assignment.task.management.api.service.UserService;
import com.assignment.task.management.api.util.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = this.userMapper.userDtoToUser(userDTO);
        this.userRepo.save(user);
        return user.getUserName();
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        if(users.size()>0) {
            List<UserResponseDTO> userDTOList = this.userMapper.userListToUserResponseDtoList(users);
            return userDTOList;
        }else {
            throw new NotFoundException("Users Not Found");
        }
    }

    @Override
    public UserResponseDTO getUser(int id) {
        if(this.userRepo.existsById(id)) {
            User user = this.userRepo.getReferenceById(id);
            UserResponseDTO userResponseDTO = this.userMapper.userToUserResponseDto(user);
            return userResponseDTO;
        }else {
            throw  new NotFoundException("User Not Found");
        }
    }

    @Override
    public String deleteUser(int id) {
        if (this.userRepo.existsById(id)){
            User user = this.userRepo.getReferenceById(id);
            this.userRepo.deleteById(id);
            return user.getUserName();
        }else {
            throw new NotFoundException("User Not Found For Delete");
        }
    }

    @Override
    public String updateUser(int id,UserUpdateRQ userUpdateRQ) {
        if ((this.userRepo.existsById(id))) {
            User user = this.userRepo.getReferenceById(id);
            user.setUserName(userUpdateRQ.getUserName());
            user.setDesignation(userUpdateRQ.getDesignation());

            this.userRepo.saveAndFlush(user);

            return user.getUserName();
        }else {
            throw new NotFoundException("User Not Found for Update");
        }
    }
}
