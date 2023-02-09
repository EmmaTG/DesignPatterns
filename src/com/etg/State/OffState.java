package com.etg.State;

public class OffState extends State {

    public OffState(Oven oven) {
        super(oven);
        this.title = "Oven is off";
    }

    @Override
    public boolean turnON() {
        System.out.println("Oven turned on");
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
        return true;
    }
}
