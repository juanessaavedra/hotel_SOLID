package org.example.infraestructure.payment;


import lombok.Data;
import org.example.interfaces.IPaymentProcessor;

@Data
public class CreditCardPayment implements IPaymentProcessor {
    private String cardNumber;

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing card payment of $" + amount + " with card ending in " +
                cardNumber.substring(cardNumber.length() - 4));
        return true; // Simulated successful payment
    }
}