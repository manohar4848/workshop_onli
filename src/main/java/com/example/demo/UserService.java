package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // Additional logic (e.g., password hashing) can be added here.
        return userRepository.save(user);
    }

    public String loginUser(String name, String password) {
        List<User> users = userRepository.findByName(name);

        if (users.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = users.get(0);

        // Ensure password matches
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user.getRole(); // Return role for role-based redirection
    }
}
