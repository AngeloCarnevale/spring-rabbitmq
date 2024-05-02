package com.angelo.demobackendworker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentErrorProducer {

    @Autowired private AmqpTemplate amqpTemplate;

    public void generateResponse (String message) {
        amqpTemplate.convertAndSend(
                "payment-response-error-exchange",
                "payment-response-error-route-key",
                message
        );
    }
}
