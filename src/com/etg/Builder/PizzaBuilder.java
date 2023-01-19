package com.etg.Builder;

import java.util.ArrayList;

public class PizzaBuilder implements IBuilder {

    private double cost;
    private SizeType size;
    private String base = "NORMAL";
    private String sauce;
    private ArrayList<String > toppings = new ArrayList<>();


    public Pizza getPizza(){
        this.setCost(this.size);
        return new Pizza(this.base, this.sauce, this.cost, this.size, this.toppings);
    }

    @Override
    public void reset() {

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

    public void setCost(SizeType size) {
        if (size==SizeType.SMALL){
            this.cost = 34.50;
        }
        else if (size==SizeType.MEDIUM){
            this.cost = 42.50;
        }
        else if (size==SizeType.LARGE){
            this.cost = 50.00;
        }
        else {
            System.out.println("No size of this type available");
        }
    }
}
