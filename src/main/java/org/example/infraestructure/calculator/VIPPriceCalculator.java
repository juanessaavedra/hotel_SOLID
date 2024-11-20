package org.example.infraestructure.calculator;


import org.example.interfaces.IPriceCalculator;
import org.example.interfaces.IRoom;

public class VIPPriceCalculator implements IPriceCalculator {
    private final IRoom room;
    private final double DISCOUNT = 0.15; // 15% discount for VIP

    public VIPPriceCalculator(IRoom room) {
        this.room = room;
    }

    @Override
    public double calculatePrice() {
        return room.getPrice() * (1 - DISCOUNT);
    }
}