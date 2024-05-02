package com.angelo.demobackendapi.dto;

import java.math.BigDecimal;

public class PaymentDTO {
    private String requestNumber;
    private BigDecimal value;
    private String product;

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
