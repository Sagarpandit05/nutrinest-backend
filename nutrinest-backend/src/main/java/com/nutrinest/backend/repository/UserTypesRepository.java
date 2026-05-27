package com.nutrinest.backend.repository;


import com.nutrinest.backend.model.UserTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserTypesRepository extends JpaRepository<UserTypes, String> {

    Optional<UserTypes> findByUserTypeName(String userTypeName);
}