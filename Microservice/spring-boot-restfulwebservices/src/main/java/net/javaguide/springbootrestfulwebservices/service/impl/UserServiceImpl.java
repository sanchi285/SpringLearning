package net.javaguide.springbootrestfulwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguide.springbootrestfulwebservices.dto.UserDto;
import net.javaguide.springbootrestfulwebservices.entity.User;
import net.javaguide.springbootrestfulwebservices.mapper.UserMapper;
import net.javaguide.springbootrestfulwebservices.repository.UserRepository;
import net.javaguide.springbootrestfulwebservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userdto) {
        //convert user Dto in to user entity
        //User user = UserMapper.mapToUser(userdto);

        User user = modelMapper.map(userdto,User.class);

        User savedUser = userRepository.save(user);
        //Convert JPA entity to user Dto
       // UserDto userDto = UserMapper.mapToUserDto(savedUser);
        UserDto userDto = modelMapper.map(savedUser,UserDto.class);
        return userDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User>  optinalUser =  userRepository.findById(userId);
        User user = optinalUser.get();
        //return UserMapper.mapToUserDto(user);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> users =  userRepository.findAll();
      //  return user.stream().map(UserMapper :: mapToUserDto)
        //        .collect(Collectors.toList());

        return users.stream().map((user)-> modelMapper.map(user,UserDto.class))
               .collect(Collectors.toList());

    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        User exixtingUser  = userRepository.findById(userDto.getId()).get();
        exixtingUser.setFirstName(userDto.getFirstName());
        exixtingUser.setLastName(userDto.getLastName());
        exixtingUser.setEmail(userDto.getEmail());
        User updated = userRepository.save(exixtingUser);
        return modelMapper.map(updated,UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
       userRepository.deleteById(id);
    }


}
