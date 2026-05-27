package com.nutrinest.backend.service.impl;

import com.nutrinest.backend.dto.AddressRequest;
import com.nutrinest.backend.model.Address;
import com.nutrinest.backend.model.User;
import com.nutrinest.backend.repository.AddressRepository;
import com.nutrinest.backend.repository.UserRepository;
import com.nutrinest.backend.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Override
    public Address addAddress(AddressRequest request, String userId) {

        // 🔍 Get user from DB
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🏗️ Map DTO → Entity
        Address address = Address.builder()
                .fullName(request.getFullName())
                .phone(request.getPhone())
                .addressLine(request.getAddressLine())
                .city(request.getCity())
                .state(request.getState())
                .pincode(request.getPincode())
                .user(user)
                .build();

        return addressRepository.save(address);
    }

    @Override
    public List<Address> getUserAddresses(String userId) {
        return addressRepository.findByUserId(userId);
    }
}