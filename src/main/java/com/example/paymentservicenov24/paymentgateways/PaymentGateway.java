package com.example.paymentservicenov24.paymentgateways;

public interface PaymentGateway {
    public String generatePaymentLink(String email, String phoneNumber, Long amount, String orderId);
}
