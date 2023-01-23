package com.etg.Builder;

import java.util.ArrayList;

public class Pizza {
    private String base;
    private String sauce;
    private double cost;
    private SizeType size;
    private ArrayList<String> toppings;

    public Pizza(String base, String sauce, double cost, SizeType size, ArrayList<String> toppings) {
        this.base = base;
        this.sauce = sauce;
        this.cost = cost;
        this.size = size;
        this.toppings = toppings;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        String s = "base='" + base + '\'' +
                ", sauce='" + sauce + '\'' +
                ", cost=" + cost +
                ", size=" + size +
                ", toppings = {";

        for (String top : toppings){
            s += top;
            if (top == toppings.get(toppings.size()-1)){
                s += "}";
            }
            else {
                s += ", ";
            }
        }

        return s;
    }
}
