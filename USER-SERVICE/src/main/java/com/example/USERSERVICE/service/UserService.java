package com.example.USERSERVICE.service;

import com.example.USERSERVICE.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUser(Integer id);
    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUser(Integer id);
}
