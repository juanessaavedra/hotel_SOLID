package org.example.domain.model;


import lombok.Data;
import org.example.interfaces.IAdditionalServices;
import org.example.interfaces.IRoom;

import java.util.HashSet;
import java.util.Set;

@Data
public class Suite implements IRoom, IAdditionalServices {
    private String id;
    private double price;
    private boolean available;
    private boolean hasJacuzzi;
    private Set<String> includedServices;

    public Suite(String id, boolean hasJacuzzi) {
        this.id = id;
        this.price = 200.0; // Base price
        this.available = true;
        this.hasJacuzzi = hasJacuzzi;
        this.includedServices = new HashSet<>();
    }

    @Override
    public void addBreakfast() {
        includedServices.add("Breakfast");
    }

    @Override
    public void addParking() {
        includedServices.add("Parking");
    }

    @Override
    public void addWifi() {
        includedServices.add("WiFi");
    }

    @Override
    public double getServicesPrice() {
        return includedServices.size() * 25.0; // $25 per service
    }
}