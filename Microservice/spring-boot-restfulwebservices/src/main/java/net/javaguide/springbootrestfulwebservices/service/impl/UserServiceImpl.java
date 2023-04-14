package net.javaguide.springbootrestfulwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguide.springbootrestfulwebservices.dto.UserDto;
import net.javaguide.springbootrestfulwebservices.entity.User;
import net.javaguide.springbootrestfulwebservices.exception.EmailAlreadyExistsException;
import net.javaguide.springbootrestfulwebservices.exception.ResourceNotFoundException;
import net.javaguide.springbootrestfulwebservices.mapper.AutoUserMapper;
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
        Optional<User> optionalUser = userRepository.findByEmail(userdto.getEmail());

        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already exist");
        }


        User user = modelMapper.map(userdto,User.class);

        User savedUser = userRepository.save(user);
        //Convert JPA entity to user Dto
       // UserDto userDto = UserMapper.mapToUserDto(savedUser);
       // UserDto userDto = modelMapper.map(savedUser,UserDto.class);
        UserDto userDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return userDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user =  userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User","id",userId)
        );

        //return UserMapper.mapToUserDto(user);
       // return modelMapper.map(user,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> users =  userRepository.findAll();
      //  return user.stream().map(UserMapper :: mapToUserDto)
        //        .collect(Collectors.toList());

       // return users.stream().map((user)-> modelMapper.map(user,UserDto.class))
        //       .collect(Collectors.toList());

        return users.stream().map((user)-> AutoUserMapper.MAPPER.mapToUserDto(user))
              .collect(Collectors.toList());

    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        User exixtingUser  = userRepository.findById(userDto.getId()).orElseThrow(
                ()->new ResourceNotFoundException("User","id",userDto.getId())
        );
        exixtingUser.setFirstName(userDto.getFirstName());
        exixtingUser.setLastName(userDto.getLastName());
        exixtingUser.setEmail(userDto.getEmail());
        User updated = userRepository.save(exixtingUser);
        return AutoUserMapper.MAPPER.mapToUserDto(updated);
    }

    @Override
    public void deleteUser(Long id) {
        User exixtingUser  = userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User","id",id)
        );
        userRepository.deleteById(id);
    }


}
