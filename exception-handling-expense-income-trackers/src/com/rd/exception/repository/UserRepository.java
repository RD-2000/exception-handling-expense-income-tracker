package com.rd.exception.repository;

import com.rd.exception.model.User;
import com.rd.exception.exceptionhandling.UserNotFoundException;

import java.util.HashMap;

    public class UserRepository {
        private HashMap<String, User> users = new HashMap<>();

        // Save a user to the repository
        public void saveUser(User user) {
            if (user == null) {
                throw new IllegalArgumentException("User cannot be null");
            }

            users.put(user.getUsername(), user);
        }

        // Get a user by username
        public User getUser(String username) {
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("Username cannot be null or empty");
            }

            User user = users.get(username);
            if (user == null) {
                throw new UserNotFoundException("User with username " + username + " not found");
            }
            return user;
        }
    }


