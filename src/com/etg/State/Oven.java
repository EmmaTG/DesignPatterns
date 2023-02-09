package com.etg.State;

// Context: delegates state-specific work
public class Oven {
    State state;
    boolean ovenON;
    boolean ovenOFF;
    boolean ovenDoorOpen;

    public Oven() {
        this.state = new OffState(this);
    }

    public void changeState(State state){
        System.out.println("Changing state from " + this.state.getTitle() + " to " + state.getTitle());
        this.state = state;
    }

    public boolean putPizzaInOven(){
        if (this.state.openDoor()){
            this.changeState(new CookingState(this));
            return true;
        }
        return false;
    }

    public boolean removePizza(){
        this.changeState(new OffState(this));
        return true;
    }

    public void ovenPreheated(){
        this.changeState(new ReadyState(this));
    }

    public void pizzaCooked(){
        this.changeState(new ReadyState(this));
    }

    public boolean turnOnOven(){
        if (this.state.turnON()) {
            this.changeState(new PreheatingState(this));
            return true;
        }
        return false;
    }

    public boolean turnOffOven(){
        return this.state.turnOFF();
    }

    public boolean openOvenDoor(){
        return this.state.openDoor();
    }
}
