package com.etg.Visitor;

import java.util.ArrayList;

public class PensionerPizza extends Element {


    public PensionerPizza(double base) {
        this.base = base;
        this.sauce = this.base/1.5;
        this.cheese = this.base/0.75;
        this.toppings = new ArrayList<>();
        this.toppings.add("Ham");
    }
    @Override
    public double accept(Visitor v) {
        return v.calculateCostPensioner(this);
    }
}
