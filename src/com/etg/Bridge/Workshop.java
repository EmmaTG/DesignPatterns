package com.etg.Bridge;

// The abstraction //

public class Workshop {

    protected Vehicle vehicle;
    public Workshop(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public double getCost(){
        return vehicle.getCost();
    }

    public String work(){
        return vehicle.doWork();
    }
}
