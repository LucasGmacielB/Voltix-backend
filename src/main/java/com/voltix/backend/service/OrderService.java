package com.voltix.backend.service;


import com.voltix.backend.model.Order;
import com.voltix.backend.model.OrderItem;
import com.voltix.backend.model.User;
import com.voltix.backend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import com.voltix.backend.config.GlobalConfigManager;
import com.voltix.backend.service.payment.PaymentStrategy;
import com.voltix.backend.service.payment.PaymentStrategyFactory;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    //TODO: implementar a classe Cart
    // Comentado para evitar erro de compilação até que Cart seja criado
    /*
    public Order createOrder(Cart cart){
        return null;
    }
    */

    //TODO: implementar a classe CartItems
    // Comentado para evitar erro de compilação até que CartItems seja criado
    /*
    public BigDecimal calcTotal(CartItems items){
        return null;
    }
    */

    public Order[] getByUser(User id){
        return null;
    }

    /**
     * Demonstração do uso dos padrões Singleton, Factory Method e Strategy.
     * 
     * @param order O pedido sendo pago.
     * @param paymentMethod O tipo do pagamento (ex: "PIX", "CREDIT_CARD").
     */
    public void processOrderPayment(Order order, String paymentMethod) {
        // 1. Uso do Singleton para pegar uma configuração global
        GlobalConfigManager config = GlobalConfigManager.getInstance();
        System.out.println("Iniciando pagamento. Moeda configurada: " + config.getDefaultCurrency());

        // 2. Uso do Factory Method para criar a Strategy correta
        PaymentStrategy strategy = PaymentStrategyFactory.createPaymentStrategy(paymentMethod);

        // 3. Uso do Strategy para processar o pagamento sem acoplar a lógica aqui
        strategy.processPayment(order, order.getTotal());
        
        // Aqui poderia haver lógica para atualizar o status do pedido e salvar no repositório
    }


}
