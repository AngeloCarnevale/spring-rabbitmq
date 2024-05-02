package com.angelo.demobackendworker.consumer;

import com.angelo.demobackendworker.producer.PaymentErrorProducer;
import com.angelo.demobackendworker.producer.PaymentSuccessProducer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentRequestConsumer {

    @Autowired
    private PaymentErrorProducer paymentErrorProducer;
    @Autowired
    private PaymentSuccessProducer paymentSuccessProducer;

    @RabbitListener(queues = {"payment-request-queue"})
    public void responseMessage (@Payload Message message) {
        System.out.println(message);

        if(new Random().nextBoolean()) {
            paymentSuccessProducer.generateResponse("Mensagem de sucesso " + message);
        }
        else {
            paymentErrorProducer.generateResponse("Erro no pagamento " + message);
        }
    }
}
