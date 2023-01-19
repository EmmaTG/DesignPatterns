package com.etg.Builder;

public class PizzaDirector {

    public void makeHawian(IBuilder builder){
        builder.addSauce("Tomato");
        builder.addTopping("Ham");
        builder.addTopping("Cheese");
        builder.addTopping("Pineapple");
    }
    public void makeDiavolo(IBuilder builder){
        builder.addSauce("Tomato");
        builder.addTopping("Salami");
        builder.addTopping("Cheese");
        builder.addTopping("Pepperoni");
    }
}
