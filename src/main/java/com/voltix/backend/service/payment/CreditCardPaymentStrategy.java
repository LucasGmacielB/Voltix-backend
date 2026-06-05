package com.voltix.backend.service.payment;

import com.voltix.backend.model.Order;
import java.math.BigDecimal;

/**
 * Implementação concreta da Strategy para processamento via Cartão de Crédito.
 */
public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public void processPayment(Order order, BigDecimal amount) {
        // Lógica de processamento com Cartão de Crédito
        System.out.println("Processando pagamento via CARTÃO DE CRÉDITO para o pedido ID " + order.getId() + " no valor de " + amount);
        // Exemplo: Comunicar com gateway de pagamento (Stripe, Pagar.me, etc.)
    }
}
