package com.etg.Factory;

// Concrete product 2
public class Projector extends IItem{
    public Projector() {
        this.weight = 30;
        this.volume = 50;
        this.lease_duration = 2; // Lease duration in hours
    }
}
