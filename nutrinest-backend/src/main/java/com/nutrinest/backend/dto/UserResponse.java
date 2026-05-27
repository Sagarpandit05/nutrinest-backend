package com.nutrinest.backend.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class UserResponse {

    private String id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String role;
    private Boolean active;
    private LocalDateTime createdAt;
}