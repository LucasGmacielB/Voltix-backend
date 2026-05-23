package com.voltix.backend.service;

import com.voltix.backend.dto.auth.LoginRequestDTO;
import com.voltix.backend.dto.auth.LoginResponseDTO;
import com.voltix.backend.dto.auth.RegisterRequestDTO;
import com.voltix.backend.model.User;
import com.voltix.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginResponseDTO register(RegisterRequestDTO dto) {
        if (userRepository.findByEmail(dto.email()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));

        User savedUser = userRepository.save(user);

        return new LoginResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("E-mail ou senha inválidos."));

        boolean passwordMatches = passwordEncoder.matches(
                dto.password(),
                user.getPassword()
        );

        if (!passwordMatches) {
            throw new RuntimeException("E-mail ou senha inválidos.");
        }

        return new LoginResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}