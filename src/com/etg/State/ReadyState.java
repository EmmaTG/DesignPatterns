package com.etg.State;

public class ReadyState extends State{
    public ReadyState(Oven oven) {
        super(oven);
        this.title = "Oven is Ready";
    }

    @Override
    public boolean turnON() {
        System.out.println("Oven is already on!");
        return false;
    }

    @Override
    public boolean turnOFF() {
        System.out.println("Turning Oven off");
        return true;
    }

    @Override
    public boolean openDoor() {
        System.out.println("Oven door opened");
        return true;
    }
}
