package com.etg.Decorator;
// Concrete Component

public class PizzaMaking implements IPizzaProduction {
    @Override
    public void assemble() {
        System.out.println("Assembling ingredients");
    }

    @Override
    public void cook() {
        System.out.println("Cooking");
    }
}
