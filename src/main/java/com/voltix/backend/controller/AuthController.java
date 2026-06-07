package com.voltix.backend.controller;

import com.voltix.backend.dto.auth.ForgotPasswordRequestDTO;
import com.voltix.backend.dto.auth.LoginRequestDTO;
import com.voltix.backend.dto.auth.LoginResponseDTO;
import com.voltix.backend.dto.auth.MessageResponseDTO;
import com.voltix.backend.dto.auth.RegisterRequestDTO;
import com.voltix.backend.dto.auth.ResetPasswordRequestDTO;
import com.voltix.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.voltix.backend.dto.auth.UpdateProfileDTO;
import com.voltix.backend.dto.auth.ChangePasswordDTO;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @PutMapping("/profile")
public LoginResponseDTO updateProfile(  @RequestBody UpdateProfileDTO dto) {
    return authService.updateProfile(dto);
}

    @PutMapping("/password")
    public MessageResponseDTO changePassword(@RequestBody ChangePasswordDTO dto) {
        authService.changePassword(dto);
        return new MessageResponseDTO("Senha alterada com sucesso.");
    }

    private final AuthService authService;

    @PostMapping("/register")
    public LoginResponseDTO register(@RequestBody RegisterRequestDTO dto) {
        return authService.register(dto);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) {
        return authService.login(dto);
    }

    @PostMapping("/forgot-password")
    public MessageResponseDTO forgotPassword(@RequestBody ForgotPasswordRequestDTO dto) {
        authService.forgotPassword(dto);
        return new MessageResponseDTO("Se o e-mail existir, enviaremos as instrucoes para redefinir a senha.");
    }

    @PostMapping("/reset-password")
    public MessageResponseDTO resetPassword(@RequestBody ResetPasswordRequestDTO dto) {
        authService.resetPassword(dto);
        return new MessageResponseDTO("Senha redefinida com sucesso.");
    }
}
