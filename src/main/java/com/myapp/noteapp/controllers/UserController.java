package com.myapp.noteapp.controllers;

import com.myapp.noteapp.entities.User;
import com.myapp.noteapp.payload.LoginBody;
import com.myapp.noteapp.payload.UserDto;
import com.myapp.noteapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Create
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto userDto = this.userService.createUser(user);
        return ResponseEntity.ok(userDto);
    }

    // upadte
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user, @PathVariable Integer userId) {
        UserDto userDto = this.userService.updateUser(user,userId);
        return ResponseEntity.ok(userDto);
    }

    // delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted sucesfully");
    }

    // get
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = this.userService.getAllUser();
        return ResponseEntity.ok(userDtos);
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<UserDto> userLogin(@RequestBody LoginBody loginBody) {
        UserDto apiRes = new UserDto();
        try {
            apiRes = this.userService.userLogin(loginBody.getEmail(), loginBody.getPassword());
            return ResponseEntity.ok(apiRes);
        } catch (Exception e) {
            return new ResponseEntity<UserDto>(apiRes, HttpStatus.UNAUTHORIZED);
        }
    }
}







