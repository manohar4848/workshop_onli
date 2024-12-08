package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createaccount")
    @ResponseStatus(HttpStatus.CREATED)
    public String createAccount(@RequestBody User user) {
        userService.createUser(user);
        return "Account created successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String role = userService.loginUser(loginRequest.getName(), loginRequest.getPassword());
        if ("User".equalsIgnoreCase(role)) {
            return "/home"; // Redirect to user home page
        } else if ("Admin".equalsIgnoreCase(role)) {
            return "/admin"; 
        } else {
            throw new RuntimeException("Invalid role");
        }
    }
}
