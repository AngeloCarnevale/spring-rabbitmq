package com.angelo.demobackendapi.facade;

import com.angelo.demobackendapi.dto.PaymentDTO;
import com.angelo.demobackendapi.producer.PaymentRequestProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentFacade {
    @Autowired private PaymentRequestProducer producer;
    public String requestPayment(PaymentDTO request) {
        try {
            producer.integrate(request);
        }catch (JsonProcessingException e) {
            return "Erro ao solicitar pagamento" + e.getMessage();
        }

        return "Pagamento aguardando confirmação...";
    }

    public void paymentSuccess(String payload) {
        System.out.println("=== Resposta de sucesso ===" +payload);
    }

    public void paymentError(String payload) {
        System.err.println("=== Resposta de erro ===" +payload);
    }
}
