package net.javaguide.springbootrestfulwebservices.controller;

import lombok.AllArgsConstructor;
import net.javaguide.springbootrestfulwebservices.entity.User;
import net.javaguide.springbootrestfulwebservices.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //build create user Rest Api
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser =  userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
