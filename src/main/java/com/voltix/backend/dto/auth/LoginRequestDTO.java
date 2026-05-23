package com.voltix.backend.dto.auth;

public record LoginRequestDTO(
        String email,
        String password
) {}