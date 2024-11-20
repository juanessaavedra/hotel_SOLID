package org.example.infraestructure.calculator;

import org.example.interfaces.IPriceCalculator;
import org.example.interfaces.IRoom;

public class StandardPriceCalculator implements IPriceCalculator {
    private final IRoom room;

    public StandardPriceCalculator(IRoom room) {
        this.room = room;
    }

    @Override
    public double calculatePrice() {
        return room.getPrice();
    }
}