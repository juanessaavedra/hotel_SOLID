package org.example.infraestructure.payment;


import lombok.*;
import org.example.interfaces.IPaymentProcessor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaypalPayment implements IPaymentProcessor {
    private String email;



    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " for " + email);
        return true; // Simulated successful payment
    }
}
