package com.rd.exception.services;


import com.rd.exception.model.User;
import com.rd.exception.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void registerUser(String username, String password) {
        User user = new User(username, password);
        userRepository.saveUser(user);
    }

    public User loginUser(String username, String password) {
        User user = userRepository.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}

