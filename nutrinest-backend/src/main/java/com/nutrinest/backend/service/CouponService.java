package com.nutrinest.backend.service;

import com.nutrinest.backend.dto.*;
import com.nutrinest.backend.model.*;
import com.nutrinest.backend.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository repository;

    public List<CouponResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public CouponResponse create(CouponRequest request) {

        Coupon coupon = Coupon.builder()
                .code(request.getCode())
                .discountType(DiscountType.valueOf(request.getDiscountType()))
                .value(request.getValue())
                .minOrderAmount(request.getMinOrderAmount())
                .maxUses(request.getMaxUses())
                .expiryDate(request.getExpiryDate())
                .usedCount(0)
                .active(true)
                .build();

        return mapToResponse(repository.save(coupon));
    }

    public CouponResponse update(String id, CouponRequest request) {

        Coupon coupon = repository.findById(id).orElseThrow();

        coupon.setCode(request.getCode());
        coupon.setDiscountType(DiscountType.valueOf(request.getDiscountType()));
        coupon.setValue(request.getValue());
        coupon.setMinOrderAmount(request.getMinOrderAmount());
        coupon.setMaxUses(request.getMaxUses());
        coupon.setExpiryDate(request.getExpiryDate());

        return mapToResponse(repository.save(coupon));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public CouponResponse validate(String code) {

        Coupon coupon = repository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Invalid coupon"));
        if (coupon.getUsedCount() == null) {
            coupon.setUsedCount(0);
        }


        if (!coupon.getActive())
            throw new RuntimeException("Coupon inactive");

        if (coupon.getExpiryDate().isBefore(LocalDate.now()))
            throw new RuntimeException("Coupon expired");

        if (coupon.getUsedCount() >= coupon.getMaxUses())
            throw new RuntimeException("Usage limit exceeded");

        return mapToResponse(coupon);
    }

    private CouponResponse mapToResponse(Coupon c) {
        return CouponResponse.builder()
                .id(c.getId())
                .code(c.getCode())
                .discountType(c.getDiscountType().name())
                .value(c.getValue())
                .minOrderAmount(c.getMinOrderAmount())
                .maxUses(c.getMaxUses())
                .usedCount(c.getUsedCount())
                .expiryDate(c.getExpiryDate())
                .active(c.getActive())
                .build();
    }
}