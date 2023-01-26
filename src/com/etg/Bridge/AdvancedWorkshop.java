package com.etg.Bridge;

// The refined abstraction //

public class AdvancedWorkshop extends Workshop{
    public AdvancedWorkshop(Vehicle vehicle) {
        super(vehicle);
        vehicle.addCost(20);
    }

    public void workQuickly(){
        System.out.println("working at x2.5 speed!!");
        vehicle.addCost(200);
    }
}
