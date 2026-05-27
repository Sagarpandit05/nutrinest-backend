package com.nutrinest.backend.service;

import com.nutrinest.backend.dto.AddressRequest;
import com.nutrinest.backend.model.Address;

import java.util.List;

public interface AddressService {

    Address addAddress(AddressRequest request, String userId);

    List<Address> getUserAddresses(String userId);
}