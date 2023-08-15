package com.example.userposts.service;

import com.example.userposts.model.Friends;
import com.example.userposts.model.User;
import com.example.userposts.repository.UsersRepository;
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
}
