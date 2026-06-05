package com.voltix.backend.service.payment;

import com.voltix.backend.model.Order;
import java.math.BigDecimal;

/**
 * Implementação concreta da Strategy para processamento via PIX.
 */
public class PixPaymentStrategy implements PaymentStrategy {

    @Override
    public void processPayment(Order order, BigDecimal amount) {
        // Lógica de processamento com PIX
        System.out.println("Processando pagamento via PIX para o pedido ID " + order.getId() + " no valor de " + amount);
        // Exemplo: Gerar QR Code, comunicar com API do Banco Central, etc.
    }
}
