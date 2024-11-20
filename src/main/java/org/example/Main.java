package org.example;

import org.example.domain.model.Customer;
import org.example.domain.model.Reservation;
import org.example.domain.model.Suite;
import org.example.domain.service.VIPReservationManager;
import org.example.exception.PaymentException;
import org.example.infraestructure.calculator.VIPPriceCalculator;
import org.example.infraestructure.payment.PaypalPayment;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create dependencies
        Customer customer = new Customer("1", "John Doe", "john@email.com", "1234567890");
        Suite suite = new Suite("101", true);
        PaypalPayment payment = new PaypalPayment("john@email.com");
        VIPPriceCalculator priceCalculator = new VIPPriceCalculator(suite);

        // Create reservation manager
        VIPReservationManager reservationManager = new VIPReservationManager(priceCalculator, payment);

        try {
            // Process reservation
            Reservation reservation = reservationManager.processReservation(
                    customer,
                    suite,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusDays(2)
            );

            System.out.println("Reservation created successfully: " + reservation.getId());

            // Modify reservation dates if needed
            reservationManager.modifyReservation(
                    reservation,
                    LocalDateTime.now().plusDays(1),
                    LocalDateTime.now().plusDays(3)
            );

            System.out.println("Reservation modified successfully");

        } catch (PaymentException e) {
            System.err.println("Payment failed: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Room not available: " + e.getMessage());
        }
    }
}