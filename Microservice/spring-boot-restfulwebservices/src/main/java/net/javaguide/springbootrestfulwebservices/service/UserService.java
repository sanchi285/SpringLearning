package net.javaguide.springbootrestfulwebservices.service;

import net.javaguide.springbootrestfulwebservices.dto.UserDto;
import net.javaguide.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userId);

    List<UserDto> getAllUser();

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long id);
}
