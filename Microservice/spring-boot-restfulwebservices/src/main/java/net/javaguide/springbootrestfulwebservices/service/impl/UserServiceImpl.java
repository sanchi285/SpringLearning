package net.javaguide.springbootrestfulwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguide.springbootrestfulwebservices.dto.UserDto;
import net.javaguide.springbootrestfulwebservices.entity.User;
import net.javaguide.springbootrestfulwebservices.repository.UserRepository;
import net.javaguide.springbootrestfulwebservices.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userdto) {
        //convert user Dto in to user entity
        User user = new User(
                userdto.getId(),
                userdto.getFirstName(),
                userdto.getLastName(),
                userdto.getEmail()
                );
        User savedUser = userRepository.save(user);
        //Convert JPA entity to user Dto
        UserDto userDto = new UserDto(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );

        return userDto;
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User>  optinalUser =  userRepository.findById(userId);
        return optinalUser.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {

        User exixtingUser  = userRepository.findById(user.getId()).get();
        exixtingUser.setFirstName(user.getFirstName());
        exixtingUser.setLastName(user.getLastName());
        exixtingUser.setEmail(user.getEmail());
        User updated = userRepository.save(exixtingUser);
        return updated;
    }

    @Override
    public void deleteUser(Long id) {
       userRepository.deleteById(id);
    }


}
