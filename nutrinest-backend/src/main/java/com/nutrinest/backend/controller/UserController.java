package com.nutrinest.backend.controller;

import com.nutrinest.backend.dto.*;
import com.nutrinest.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    // 🔥 REGISTER
    @PostMapping("/register")
    public String register(@RequestBody UserRegisterRequest request) {
        return userService.register(request);
    }

    // 🔥 LOGIN
    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody UserLoginRequest request) {
        return userService.login(request);
    }

    // 🔥 GET ALL USERS
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    // 🔥 GET USER BY ID
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // 🔥 BLOCK / UNBLOCK USER
    @PutMapping("/{id}/toggle-status")
    public String toggleUserStatus(@PathVariable String id) {
        userService.toggleUserStatus(id);
        return "User status updated";
    }
}