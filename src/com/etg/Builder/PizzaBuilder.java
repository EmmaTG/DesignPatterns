package com.etg.Builder;

import java.util.ArrayList;

public class PizzaBuilder implements IBuilder {

    private double cost;
    private double baseCost;
    private SizeType size;
    private String base = "NORMAL";
    private String sauce;
    private ArrayList<String > toppings = new ArrayList<>();


    public Pizza getPizza(){
        this.setCost(this.size);
        Pizza newPizza = new Pizza(this.base, this.sauce, this.cost, this.size, this.toppings);
        this.reset();
        return newPizza;
    }

    @Override
    public void reset() {
        this.cost = 0;
        this.size = null;
        this.base = "NORMAL";
        this.sauce = "";
        this.toppings = new ArrayList<>();
    }

    @Override
    public void setSize(SizeType size) {
        this.size = size;
    }

    @Override
    public void makeBase(String base) {
        this.base = base;
    }

    @Override
    public void addSauce(String sauce) {
        this.sauce = sauce;
    }

    @Override
    public void addTopping(String top1) {
        this.toppings.add(top1);
    }

    @Override
    public void setBaseCost(double cost) {
        this.baseCost = cost;
    }

    public void setCost(SizeType size) {
        if (size==SizeType.SMALL){
            this.cost = this.baseCost;
        }
        else if (size==SizeType.MEDIUM){
            this.cost = this.baseCost + 5.0;
        }
        else if (size==SizeType.LARGE){
            this.cost = this.baseCost + 7.5;
        }
        else {
            System.out.println("No size of this type available");
        }
        if (base.equals("GLUTENFREE")){
            this.cost += 4.5;
        }
    }
}
