package com.etg.State;

// Interface  declaring state specific methods common to all concrete state objects
public abstract class State {

    protected Oven oven;
    String title;

    public State(Oven oven) {
        this.oven = oven;
    }

    public String getTitle() {
        return title;
    }

    public abstract boolean turnON();
    public abstract boolean turnOFF();
    public abstract boolean openDoor();
}
