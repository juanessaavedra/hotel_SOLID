package org.example.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VIPReservation extends Reservation {
    private List<String> additionalBenefits;

    public VIPReservation() {
        this.additionalBenefits = new ArrayList<>();
    }

    public void addBenefit(String benefit) {
        additionalBenefits.add(benefit);
    }
}