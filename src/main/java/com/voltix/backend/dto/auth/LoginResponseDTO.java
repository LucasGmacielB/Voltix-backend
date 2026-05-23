package com.voltix.backend.dto.auth;

public record LoginResponseDTO(
        Long id,
        String name,
        String email
) {}