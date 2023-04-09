package net.javaguide.springbootrestfulwebservices.service;

import net.javaguide.springbootrestfulwebservices.entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
}
