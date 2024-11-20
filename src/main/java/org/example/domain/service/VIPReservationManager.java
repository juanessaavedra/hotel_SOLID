package org.example.domain.service;


import org.example.domain.model.Customer;
import org.example.domain.model.Reservation;
import org.example.domain.model.Suite;
import org.example.domain.model.VIPReservation;
import org.example.interfaces.IPaymentProcessor;
import org.example.interfaces.IPriceCalculator;
import org.example.interfaces.IRoom;

import java.time.LocalDateTime;

public class VIPReservationManager extends ReservationManager {
    public VIPReservationManager(IPriceCalculator priceCalculator, IPaymentProcessor paymentProcessor) {
        super(priceCalculator, paymentProcessor);
    }

    @Override
    public Reservation processReservation(Customer customer, IRoom room, LocalDateTime checkIn, LocalDateTime checkOut) {
        VIPReservation vipReservation = new VIPReservation();
        Reservation baseReservation = super.processReservation(customer, room, checkIn, checkOut);

        // Copy properties manually instead of using Spring's BeanUtils
        vipReservation.setId(baseReservation.getId());
        vipReservation.setCustomer(baseReservation.getCustomer());
        vipReservation.setRoom(baseReservation.getRoom());
        vipReservation.setCheckIn(baseReservation.getCheckIn());
        vipReservation.setCheckOut(baseReservation.getCheckOut());

        // Add VIP benefits
        vipReservation.addBenefit("Priority Check-in");
        vipReservation.addBenefit("Late Check-out");
        vipReservation.addBenefit("Welcome Drink");

        if (room instanceof Suite) {
            Suite suite = (Suite) room;
            suite.addBreakfast();
            suite.addWifi();
            suite.addParking();
        }

        return vipReservation;
    }
}