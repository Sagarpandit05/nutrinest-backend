package com.nutrinest.backend.controller;

import com.nutrinest.backend.dto.AddressRequest;
import com.nutrinest.backend.model.Address;
import com.nutrinest.backend.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AddressController {

    private final AddressService addressService;

    // ✅ Add Address (with userId)
    @PostMapping("/{userId}")
    public Address addAddress(@RequestBody AddressRequest request,
                              @PathVariable String userId) {
        return addressService.addAddress(request, userId);
    }

    // ✅ Get All Addresses of User
    @GetMapping("/{userId}")
    public List<Address> getUserAddresses(@PathVariable String userId) {
        return addressService.getUserAddresses(userId);
    }
}