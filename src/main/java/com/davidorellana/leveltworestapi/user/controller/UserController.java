package com.davidorellana.leveltworestapi.user.controller;

import com.davidorellana.leveltworestapi.user.data.User;
import com.davidorellana.leveltworestapi.user.dto.UserDto;
import com.davidorellana.leveltworestapi.user.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserServiceI userService;

    @Autowired
    public UserController(UserServiceI userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<HashMap<Integer, User>> allUsers() {
        HashMap<Integer, User> allUsers = userService.allUsers();
        if (allUsers.isEmpty()) {
            return new ResponseEntity("There are no users to display :(", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Integer idUser) {
        User user = userService.findUserById(idUser);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity("That user id does not exist!", HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User user = new User(userDto);
        Optional<User> userValidation = Optional.ofNullable(userService.createUser(user));
        if (userValidation != null) {
            return new ResponseEntity("Created user!", HttpStatus.CREATED);
        }
        return new ResponseEntity("User not created!", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer idUser, @RequestBody UserDto userDto) {
        User user = new User(userDto);
        User isUpdated = userService.updateUser(idUser, user);
        if (isUpdated != null){
            return new ResponseEntity("Updated user", HttpStatus.OK);
        }else{
            return new ResponseEntity("User not updated by id not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") Integer idUser) {
        User user = userService.deleteUserById(idUser);
        if (user != null) {
            return new ResponseEntity("User Deleted!", HttpStatus.OK);
        }
        return new ResponseEntity("The user does not exist to be deleted!",HttpStatus.NOT_FOUND);
    }
}
