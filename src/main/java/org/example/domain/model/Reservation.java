package org.example.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.interfaces.IRoom;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private String id;
    private Customer customer;
    private IRoom room;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public double calculateTotal() {
        return room.getPrice();
    }
}