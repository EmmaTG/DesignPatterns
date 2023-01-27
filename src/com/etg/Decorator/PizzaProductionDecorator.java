package com.etg.Decorator;

public class PizzaProductionDecorator implements IPizzaProduction {

    private IPizzaProduction wrappee;

    public PizzaProductionDecorator(IPizzaProduction pizzaProduction) {
        this.wrappee = pizzaProduction;
    }

    @Override
    public void assemble() {
        this.wrappee.assemble();
    }

    @Override
    public void cook() {
        this.wrappee.cook();
    }
}
