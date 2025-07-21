package com.myapp.noteapp.service;

import com.myapp.noteapp.payload.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // straightforward CRUD implementations

    // create
    UserDto createUser(UserDto userDto);

    // update
    UserDto updateUser(UserDto userDto,Integer id);

    // delete
    void deleteUser(Integer id);

    // get
    UserDto getUser(Integer id);

    // getAll
    List<UserDto> getAllUser();

    // user login
    UserDto userLogin(String email, String password);

}
