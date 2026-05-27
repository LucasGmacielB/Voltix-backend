package com.voltix.backend.repository;

import com.voltix.backend.model.PasswordResetToken;
import com.voltix.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByTokenAndUsedAtIsNull(String token);

    void deleteByUserAndUsedAtIsNull(User user);
}
