package com.etg.Builder;

public class PizzaDirector {

    public void makeHawian(IBuilder builder){
        builder.addSauce("Tomato");
        builder.addTopping("Ham");
        builder.addTopping("Cheese");
        builder.addTopping("Pineapple");
        builder.setBaseCost(30.0);
    }
    public void makeDiavolo(IBuilder builder){
        builder.addSauce("Tomato");
        builder.addTopping("Salami");
        builder.addTopping("Cheese");
        builder.addTopping("Pepperoni");
        builder.setBaseCost(40.0);
    }

    public void makeGlutenFree(IBuilder builder){
        builder.makeBase("GLUTENFREE");
    }

    public void makeSmall(IBuilder builder){
        builder.setSize(SizeType.SMALL);
    }

    public void makeMedium(IBuilder builder){
        builder.setSize(SizeType.MEDIUM);
    }

    public void makeLarge(IBuilder builder){
        builder.setSize(SizeType.LARGE);
    }
}
