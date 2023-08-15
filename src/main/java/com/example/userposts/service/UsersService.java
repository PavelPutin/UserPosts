package com.example.userposts.service;

import com.example.userposts.model.Friends;
import com.example.userposts.model.User;
import com.example.userposts.repository.UsersRepository;
import com.example.userposts.util.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAll() {
        return usersRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return usersRepository.findById(id);
    }

    public List<User> getUserFriendsById(String id) {
        Optional<User> optUser = usersRepository.findById(id);
        User user = optUser.orElseThrow(() -> new UserNotFoundException(id));
        return user.getFriends();
    }
}
