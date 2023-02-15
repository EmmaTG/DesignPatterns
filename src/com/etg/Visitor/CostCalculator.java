package com.etg.Visitor;

public class CostCalculator implements Visitor{
    double basePerUnit = 2;
    double saucePerUnit = 0.5;
    double cheesePerUnit = 4;

    private double costCalculation(Element pizza){
        double cost = 0;
        cost += pizza.base*basePerUnit;
        cost += pizza.cheese*cheesePerUnit;
        cost += pizza.sauce*saucePerUnit;
        cost += pizza.toppings.size()*10;
        return cost;
    }

    @Override
    public double calculateCostChild(ChildPizza pizza) {
        double cost = costCalculation(pizza);
        cost = cost*0.5; // Half off child pizzas
        return cost;
    }

    @Override
    public double calculateCostAdult(AdultPizza pizza) {
        double cost = costCalculation(pizza);
        return cost;
    }

    @Override
    public double calculateCostPensioner(PensionerPizza pizza) {
        double cost = costCalculation(pizza);
        cost = cost*0.75; // 75% for pensioners pizzas
        return cost;
    }
}
