package com.voltix.backend.service.payment;

import com.voltix.backend.model.Order;
import java.math.BigDecimal;

/**
 * Padrão Strategy - GoF
 * Interface que define o contrato para diferentes estratégias de pagamento.
 */
public interface PaymentStrategy {
    void processPayment(Order order, BigDecimal amount);
}
