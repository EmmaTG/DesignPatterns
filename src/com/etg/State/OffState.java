package com.etg.State;

public class OffState extends State {

    public OffState(Oven oven) {
        super(oven);
        this.title = "Oven is off";
        this.oven.ovenON = false;
        this.oven.ovenOFF = true;
        this.oven.ovenDoorOpen = false;
    }

    @Override
    public boolean turnON() {
        System.out.println("Oven turned on");
        this.oven.ovenON = true;
        return true;
    }

    @Override
    public boolean turnOFF() {
        System.out.println("Oven is already off!");
        return false;
    }

    @Override
    public boolean openDoor() {
        System.out.println("Oven door opened");
        this.oven.ovenDoorOpen = true;
        return true;
    }
}
