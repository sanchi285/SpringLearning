package net.javaguide.springbootrestfulwebservices.mapper;

import net.javaguide.springbootrestfulwebservices.dto.UserDto;
import net.javaguide.springbootrestfulwebservices.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User savedUser){
        UserDto userDto = new UserDto(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );
        return userDto;
    }

    public static User mapToUser(UserDto userdto){
        User user = new User(
                userdto.getId(),
                userdto.getFirstName(),
                userdto.getLastName(),
                userdto.getEmail()
        );
        return user;
    }
}
