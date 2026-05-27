package com.nutrinest.backend.service.impl;
import com.nutrinest.backend.model.UserTypes;
import com.nutrinest.backend.repository.UserTypesRepository;
import com.nutrinest.backend.service.UserTypesService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserTypesServiceImpl implements UserTypesService {

    private final UserTypesRepository repository;

    public UserTypesServiceImpl(UserTypesRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserTypes createUserType(UserTypes userType) {
        return repository.save(userType);
    }

    @Override
    public List<UserTypes> getAllUserTypes() {
        return repository.findAll();
    }

    @Override
    public UserTypes getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserType not found"));
    }

    @Override
    public void deleteUserType(String id) {
        repository.deleteById(id);
    }
}