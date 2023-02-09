package com.etg.State;

public class CookingState extends State{
    public CookingState(Oven oven) {
        super(oven);
        this.title = "Cooking a pizza";
    }

    @Override
    public boolean turnON() {
        System.out.println("Oven is already on!");
        return false;
    }

    @Override
    public boolean turnOFF() {
        System.out.println("A Pizza is cooking! You can't turn the oven off now!!");
        return false;
    }

    @Override
    public boolean openDoor() {
        System.out.println("A Pizza is cooking! You can't open the door now!!");
        return false;
    }
}
