package com.nutrinest.backend.service.impl;

import com.nutrinest.backend.dto.*;
import com.nutrinest.backend.exception.*;
import com.nutrinest.backend.model.User;
import com.nutrinest.backend.model.UserTypes;
import com.nutrinest.backend.repository.UserRepository;
import com.nutrinest.backend.repository.UserTypesRepository;
import com.nutrinest.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserTypesRepository userTypesRepository;

    // ================= REGISTER =================
    @Override
    public String register(UserRegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already registered");
        }

        if (userRepository.findByPhoneNumber(request.getPhoneNumber()).isPresent()) {
            throw new PhoneAlreadyExistsException("Phone already registered");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setActive(true);

        // 🔥 UserType logic
        if (request.getUserTypeId() != null) {
            UserTypes userType = userTypesRepository.findById(request.getUserTypeId())
                    .orElseThrow(() -> new RuntimeException("Invalid UserType"));
            user.setUserType(userType);
        } else {
            UserTypes defaultUser = userTypesRepository.findByUserTypeName("USER")
                    .orElseThrow(() -> new RuntimeException("Default USER not found"));
            user.setUserType(defaultUser);
        }

        userRepository.save(user);
        return "User registered successfully";
    }

    // ================= LOGIN =================
    @Override
    public UserLoginResponse login(UserLoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }

        String role = user.getUserType() != null
                ? user.getUserType().getUserTypeName()
                : "USER";

        return new UserLoginResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                role
        );
    }

    // ================= GET ALL =================
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ================= GET BY ID =================
    @Override
    public UserResponse getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return mapToResponse(user);
    }

    // ================= BLOCK / UNBLOCK =================
    @Override
    public void toggleUserStatus(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setActive(!user.isActive());
        userRepository.save(user);
    }

    // ================= MAPPING =================
    private UserResponse mapToResponse(User u) {
        return UserResponse.builder()
                .id(u.getId())
                .fullName(
                        (u.getFirstName() != null ? u.getFirstName() : "") + " " +
                                (u.getLastName() != null ? u.getLastName() : "")
                )
                .email(u.getEmail())
                .phoneNumber(u.getPhoneNumber())
                .role(u.getUserType() != null ? u.getUserType().getUserTypeName() : "USER")
                .active(u.isActive())
                .createdAt(u.getCreatedAt())
                .build();
    }
}