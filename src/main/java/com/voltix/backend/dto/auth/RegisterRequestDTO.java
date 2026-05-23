package com.voltix.backend.dto.auth;

public record RegisterRequestDTO(
        String name,
        String email,
        String password
) {}