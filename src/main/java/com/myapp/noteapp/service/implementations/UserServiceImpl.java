package com.myapp.noteapp.service.implementations;

import com.myapp.noteapp.entities.User;
import com.myapp.noteapp.payload.UserDto;
import com.myapp.noteapp.repositories.UserRepository;
import com.myapp.noteapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // create
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.userRepository.save(this.DtoToUser(userDto));
        return this.UserToDto(user);
    }

    // upadate
    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        User user = this.userRepository.findById(id).orElseThrow();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(user);
        return this.UserToDto(updatedUser);
    }

    // delete
    @Override
    public void deleteUser(Integer id) {
        User user = this.userRepository.findById(id).orElseThrow();
        this.userRepository.delete(user);
    }

    // get
    @Override
    public UserDto getUser(Integer id) {
        User user = this.userRepository.findById(id).orElseThrow();
        return this.UserToDto(user);
    }

    // getAll
    @Override
    public List<UserDto> getAllUser() {
        List<User> user = this.userRepository.findAll();
        List<UserDto> allNotes = user.stream()
                .map(u -> this.UserToDto(u))
                .collect(Collectors.toList());
        return user.stream()
                .map(u -> this.UserToDto(u))
                .collect(Collectors.toList());
    }


    // login
    @Override
    public UserDto userLogin(String email, String password) {
        User user = this.userRepository.findByEmailAndPassword(email,password);
        return this.UserToDto(user);
    }

    public User DtoToUser(UserDto userDto ) {
        User user= new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto UserToDto(User user ) {
        UserDto userDto= new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
