package com.voltix.backend.dto.auth;

public record UpdateProfileDTO(
        Long id,
        String name,
        String email
) {}