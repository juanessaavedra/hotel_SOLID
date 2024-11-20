package org.example.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.interfaces.IRoom;

@Data
@AllArgsConstructor
public class StandardRoom implements IRoom {
    private String id;
    private double price;
    private boolean available;

    public StandardRoom(String id) {
        this.id = id;
        this.price = 100.0; // Base price
        this.available = true;
    }
}