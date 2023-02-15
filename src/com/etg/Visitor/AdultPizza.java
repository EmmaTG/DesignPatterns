package com.etg.Visitor;

import java.util.ArrayList;

public class AdultPizza extends Element {

    public AdultPizza(double base, String topping) {
        this.base = base;
        this.sauce = this.base/2.;
        this.cheese = this.base;
        this.toppings = new ArrayList<>();
        this.toppings.add(topping);
    }

    @Override
    public void addExtraCheese(){
        this.cheese += 5;
    }

    @Override
    public double accept(Visitor v) {
        return v.calculateCostAdult(this);
    }
}
