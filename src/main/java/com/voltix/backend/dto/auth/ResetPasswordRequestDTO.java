package com.voltix.backend.dto.auth;

public record ResetPasswordRequestDTO(
        String token,
        String newPassword
) {}
