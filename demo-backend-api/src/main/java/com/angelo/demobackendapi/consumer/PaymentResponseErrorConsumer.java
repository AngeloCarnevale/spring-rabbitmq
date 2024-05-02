package com.angelo.demobackendapi.consumer;

import com.angelo.demobackendapi.facade.PaymentFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentResponseErrorConsumer {

    @Autowired private PaymentFacade paymentFacade;

    @RabbitListener(queues = {"payment-response-error-queue"})
    public void receive(@Payload Message message) {
        System.out.println("Message "+message);
        String payload = String.valueOf(message.getPayload());

        paymentFacade.paymentError(payload);
    }
}
