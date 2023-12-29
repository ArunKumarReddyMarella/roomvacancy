package com.example.USERSERVICE.service.impl;

import com.example.USERSERVICE.entity.User;
import com.example.USERSERVICE.repository.UserRepository;
import com.example.USERSERVICE.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        log.info(users.toString());
        return users;
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new RuntimeException("User not found");
        log.info(user.get().toString());
        return user.get();
    }

    @Override
    public User createUser(User user) {
        User createdUser = userRepository.saveAndFlush(user);
        log.info(createdUser.toString());
        return createdUser;
    }

    @Override
    public User updateUser(User user) {
        User updatedUser = userRepository.saveAndFlush(user);
        log.info(updatedUser.toString());
        return updatedUser;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
