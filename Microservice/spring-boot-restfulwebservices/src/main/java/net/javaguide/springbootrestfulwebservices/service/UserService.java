package net.javaguide.springbootrestfulwebservices.service;

import net.javaguide.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);

    List<User> getAllUser();

    User updateUser(User user);

    void deleteUser(Long id);
}
