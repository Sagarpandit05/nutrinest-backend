package com.nutrinest.backend.repository;

import com.nutrinest.backend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {

    List<Address> findByUserId(String userId);
}