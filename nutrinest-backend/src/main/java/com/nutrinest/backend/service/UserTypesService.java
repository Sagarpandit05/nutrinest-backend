package com.nutrinest.backend.service;
import com.nutrinest.backend.model.UserTypes;

import java.util.List;


public interface UserTypesService {

    UserTypes createUserType(UserTypes userType);

    List<UserTypes> getAllUserTypes();

    UserTypes getById(String id);

    void deleteUserType(String id);
}