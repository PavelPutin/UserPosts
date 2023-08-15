package com.example.userposts.controller;

import com.example.userposts.dto.UserDTO;
import com.example.userposts.model.User;
import com.example.userposts.service.UsersService;
import com.example.userposts.util.ErrorResponse;
import com.example.userposts.util.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService usersService;
    private final ModelMapper modelMapper;

    public UsersController(UsersService usersService, ModelMapper modelMapper) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return usersService.getAll().stream().map(this::convertToUserDTO).toList();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable("id") String id) {
        Optional<User> optUser = usersService.getUserById(id);
        return convertToUserDTO(optUser.orElseThrow(() -> new UserNotFoundException(id)));
    }

    @ExceptionHandler
    public ErrorResponse handleException(UserNotFoundException e) {
        String message = "User with id " + e.getUserId() + " not found";
        return new ErrorResponse(message, LocalDateTime.now());
    }

    private UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
