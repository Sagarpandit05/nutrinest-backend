package com.nutrinest.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {

    private String fullName;

    private String phone;

    private String addressLine;

    private String city;

    private String state;

    private String pincode;
}