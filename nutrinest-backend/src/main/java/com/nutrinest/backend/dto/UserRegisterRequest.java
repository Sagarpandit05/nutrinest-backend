package com.nutrinest.backend.dto;

import lombok.Data;

@Data
public class UserRegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String userTypeId;
}