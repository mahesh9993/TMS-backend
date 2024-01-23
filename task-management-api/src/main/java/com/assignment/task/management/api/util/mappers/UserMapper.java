package com.assignment.task.management.api.util.mappers;

import com.assignment.task.management.api.dto.UserDTO;
import com.assignment.task.management.api.dto.response.UserResponseDTO;
import com.assignment.task.management.api.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    User userDtoToUser (UserDTO userDTO);

    List<UserDTO> userListToUserDtoList(List<User> users);

    UserResponseDTO userToUserResponseDto(User user);

    List<UserResponseDTO> userListToUserResponseDtoList(List<User> users);
}
