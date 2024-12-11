package com.example.paymentservicenov24.controllers;

import com.example.paymentservicenov24.dtos.InitiatePayementDto;
import com.example.paymentservicenov24.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public String initiatePayment(@RequestBody InitiatePayementDto initiatePayementDto) {

        return paymentService.initiatePayment(
                initiatePayementDto.getEmail(),
                initiatePayementDto.getPhoneNumber(),
                initiatePayementDto.getAmount(),
                initiatePayementDto.getOrderId());
    }

    @PostMapping("/webhook")
    public String listenToWebhook(@RequestBody String webhookEvent) {
        System.out.println(webhookEvent);
        return "OK";
    }
}
