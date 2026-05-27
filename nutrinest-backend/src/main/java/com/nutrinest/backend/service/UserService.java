package com.nutrinest.backend.service;

import com.nutrinest.backend.dto.*;
import java.util.List;

public interface UserService {

    String register(UserRegisterRequest request);

    UserLoginResponse login(UserLoginRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(String id);   // 🔥 add this

    void toggleUserStatus(String id);
}