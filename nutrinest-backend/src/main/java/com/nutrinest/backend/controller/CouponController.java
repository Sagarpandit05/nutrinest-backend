package com.nutrinest.backend.controller;

import com.nutrinest.backend.dto.*;
import com.nutrinest.backend.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
@CrossOrigin
public class CouponController {

    private final CouponService service;

    @GetMapping
    public List<CouponResponse> getAll() {
        return service.getAll();
    }

    @PostMapping
    public CouponResponse create(@RequestBody CouponRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public CouponResponse update(@PathVariable String id,
                                 @RequestBody CouponRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/validate")
    public CouponResponse validate(@RequestBody ValidateRequest req) {
        return service.validate(req.getCode());
    }
}