package org.example.domain.service;


import lombok.AllArgsConstructor;
import org.example.domain.model.Customer;
import org.example.domain.model.Reservation;
import org.example.exception.PaymentException;
import org.example.interfaces.IPaymentProcessor;
import org.example.interfaces.IPriceCalculator;
import org.example.interfaces.IRoom;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
public class ReservationManager {
    private final IPriceCalculator priceCalculator;
    private final IPaymentProcessor paymentProcessor;

    public Reservation processReservation(Customer customer, IRoom room, LocalDateTime checkIn, LocalDateTime checkOut) {
        if (!room.isAvailable()) {
            throw new IllegalStateException("Room is not available");
        }

        double totalPrice = priceCalculator.calculatePrice();

        if (!paymentProcessor.processPayment(totalPrice)) {
            throw new PaymentException("Payment failed");
        }

        room.setAvailable(false);

        return new Reservation(
                UUID.randomUUID().toString(),
                customer,
                room,
                checkIn,
                checkOut
        );
    }

    public void modifyReservation(Reservation reservation, LocalDateTime newCheckIn, LocalDateTime newCheckOut) {
        reservation.setCheckIn(newCheckIn);
        reservation.setCheckOut(newCheckOut);
    }
}