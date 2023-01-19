package com.platzi.javatest.payments;

public class PaymentResponse {
    enum PaymentStatus {OK, ERROR}

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    private PaymentStatus status;

    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }
}
