package org.example.interfaces;

public interface IRoom {
    String getId();
    double getPrice();
    void setPrice(double price);
    boolean isAvailable();
    void setAvailable(boolean available);
}