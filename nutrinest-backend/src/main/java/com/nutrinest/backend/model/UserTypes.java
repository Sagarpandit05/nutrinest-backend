package com.nutrinest.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_types")
@Data
public class UserTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userTypeId;

    @Column(nullable = false, unique = true)
    private String userTypeName; // USER, ADMIN
}