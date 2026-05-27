package com.nutrinest.backend.controller;
import com.nutrinest.backend.model.UserTypes;
import com.nutrinest.backend.service.UserTypesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user-types")
@CrossOrigin("*")
public class UserTypesController {

    private final UserTypesService service;

    public UserTypesController(UserTypesService service) {
        this.service = service;
    }

    // ✅ Create
    @PostMapping
    public UserTypes create(@RequestBody UserTypes userType) {
        return service.createUserType(userType);
    }

    // ✅ Get All
    @GetMapping
    public List<UserTypes> getAll() {
        return service.getAllUserTypes();
    }

    // ✅ Get By ID
    @GetMapping("/{id}")
    public UserTypes getById(@PathVariable String id) {
        return service.getById(id);
    }

    // ✅ Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.deleteUserType(id);
        return "Deleted Successfully";
    }
}