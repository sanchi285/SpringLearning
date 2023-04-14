package net.javaguide.springbootrestfulwebservices.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguide.springbootrestfulwebservices.dto.UserDto;
import net.javaguide.springbootrestfulwebservices.entity.User;
import net.javaguide.springbootrestfulwebservices.exception.ErrorDetails;
import net.javaguide.springbootrestfulwebservices.exception.ResourceNotFoundException;
import net.javaguide.springbootrestfulwebservices.service.UserService;
import org.apache.catalina.UserDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //build create user Rest Api
    @PostMapping()
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser =  userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //get all user controlle
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody @Valid UserDto userdto){
       userdto.setId(userId);
       UserDto updated = userService.updateUser(userdto);
       return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
    }

    /*
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotfoundException(ResourceNotFoundException resourceNotFoundException,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
          LocalDateTime.now(),
          resourceNotFoundException.getMessage(),
          webRequest.getDescription(false),
            "USER_NOT_FOUND"
        );

        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }
     */
}
