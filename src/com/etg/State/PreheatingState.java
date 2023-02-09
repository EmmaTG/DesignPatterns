package com.etg.State;

public class PreheatingState extends State {
    public PreheatingState(Oven oven) {
        super(oven);
        this.title = "Preheating";
    }

    @Override
    public boolean turnON() {
        System.out.println("Oven is already on!");
        return false;
    }

    @Override
    public boolean turnOFF() {
        System.out.println("You cannot turn off the oven whilst preheating");
        return false;
    }

    @Override
    public boolean openDoor() {
        System.out.println("Oven door opened, BUT it is NOT preheated yet!");
        return true;
    }
}
