package com.etg.Factory;

// Concrete product 1
public class Computer extends IItem{
    public Computer() {
        this.weight = 20;
        this.volume = 100;
        this.lease_duration = 8; // Lease duration in hours
    }
}
