package net.javaguide.springbootrestfulwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguide.springbootrestfulwebservices.entity.User;
import net.javaguide.springbootrestfulwebservices.repository.UserRepository;
import net.javaguide.springbootrestfulwebservices.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User>  optinalUser =  userRepository.findById(userId);
        return optinalUser.get();
    }
}
