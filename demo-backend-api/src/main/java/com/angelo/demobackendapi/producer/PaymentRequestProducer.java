package com.angelo.demobackendapi.producer;

import com.angelo.demobackendapi.dto.PaymentDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestProducer {

    @Autowired private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();
    public void integrate (PaymentDTO payment) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "payment-request-exchange",
                "payment-request-route-key",
                objectMapper.writeValueAsString(payment)
        );
    }
}
