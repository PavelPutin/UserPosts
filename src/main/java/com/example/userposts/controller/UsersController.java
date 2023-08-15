package com.example.userposts.controller;

import com.example.userposts.dto.IncomingFriendsDTO;
import com.example.userposts.dto.OutgoingFriendsDTO;
import com.example.userposts.dto.UserDTO;
import com.example.userposts.model.Friends;
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
@RequestMapping("/users")
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

    @GetMapping("/{id}/friends/incoming")
    public List<IncomingFriendsDTO> getIncomingFriendRequests(@PathVariable("id") String id) {
        Optional<User> optUser = usersService.getUserById(id);
        User user = optUser.orElseThrow(() -> new UserNotFoundException(id));
        List<Friends> incoming = user.getIncoming();
        return incoming.stream().map(this::convertToIncomingFriendsDTO).toList();
    }

    @GetMapping("/{id}/friends/outgoing")
    public List<OutgoingFriendsDTO> getOutgoingFriendRequests(@PathVariable("id") String id) {
        Optional<User> optUser = usersService.getUserById(id);
        User user = optUser.orElseThrow(() -> new UserNotFoundException(id));
        List<Friends> incoming = user.getOutgoing();
        return incoming.stream().map(this::convertToOutgoingFriendsDTO).toList();
    }

    @GetMapping("/{id}/friends")
    public List<UserDTO> getFriends(@PathVariable("id") String id) {
        return usersService.getUserFriendsById(id).stream().map(this::convertToUserDTO).toList();
    }

    @ExceptionHandler
    public ErrorResponse handleException(UserNotFoundException e) {
        String message = "User with id " + e.getUserId() + " not found";
        return new ErrorResponse(message, LocalDateTime.now());
    }

    private UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    private IncomingFriendsDTO convertToIncomingFriendsDTO(Friends friends) {
        return modelMapper.map(friends, IncomingFriendsDTO.class);
    }

    private OutgoingFriendsDTO convertToOutgoingFriendsDTO(Friends friends) {
        return modelMapper.map(friends, OutgoingFriendsDTO.class);
    }
}
