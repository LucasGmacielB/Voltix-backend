package com.voltix.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.mail.from:}")
    private String mailFrom;

    public void sendPasswordResetEmail(String to, String resetLink) {
        if (!StringUtils.hasText(mailFrom)) {
            throw new IllegalStateException("Configure app.mail.from ou MAIL_USERNAME para enviar e-mails.");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailFrom);
        message.setTo(to);
        message.setSubject("Recuperacao de senha - Voltix");
        message.setText("""
                Recebemos uma solicitacao para redefinir sua senha.

                Acesse o link abaixo para criar uma nova senha:
                %s

                Se voce nao solicitou essa alteracao, ignore este e-mail.
                """.formatted(resetLink));

        mailSender.send(message);
    }
}
