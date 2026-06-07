package com.voltix.backend.dto.auth;

public record ChangePasswordDTO(
        Long id,
        String currentPassword,
        String newPassword
) {}