package com.etg.Visitor;

import java.util.ArrayList;

public abstract class Element {

    double base;
    double sauce;
    double cheese;
    ArrayList<String> toppings;

    public void addExtraCheese(){
        this.cheese += 2;
    }

    public void addTopping(String topping){
        this.toppings.add(topping);
    }

    public double getBase() {
        return base;
    }

    public double getSauce() {
        return sauce;
    }

    public double getCheese() {
        return cheese;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public abstract double accept(Visitor v);

    @Override
    public String toString() {
        return "Element{" +
                "base=" + base +
                ", sauce=" + sauce +
                ", cheese=" + cheese +
                ", toppings=" + toppings +
                '}';
    }
}
