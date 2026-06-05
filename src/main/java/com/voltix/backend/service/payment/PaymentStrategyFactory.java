package com.voltix.backend.service.payment;

/**
 * Padrão Factory Method - GoF
 * Fábrica responsável por encapsular a lógica de instanciação das estratégias de pagamento.
 */
public class PaymentStrategyFactory {

    /**
     * Cria e retorna a estratégia correta baseada no método passado como parâmetro.
     * 
     * @param paymentMethod O método de pagamento (ex: "PIX", "CREDIT_CARD")
     * @return PaymentStrategy correspondente
     */
    public static PaymentStrategy createPaymentStrategy(String paymentMethod) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException("O método de pagamento não pode ser nulo");
        }

        switch (paymentMethod.toUpperCase()) {
            case "PIX":
                return new PixPaymentStrategy();
            case "CREDIT_CARD":
                return new CreditCardPaymentStrategy();
            default:
                throw new IllegalArgumentException("Método de pagamento desconhecido: " + paymentMethod);
        }
    }
}
