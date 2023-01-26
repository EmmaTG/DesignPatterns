package com.etg.Bridge;

// Implementor/ation for bridge pattern

public abstract class Vehicle {
    double cost;
    boolean fixed;
    String currentState;

    abstract String doWork();
    abstract String diagnoseProblem();

    public Vehicle() {
        this.currentState = "Inprogress";
    }

    public double getCost(){
        return this.cost;
    };
    public void addCost(double cost){
        this.cost += cost;
    };


}
