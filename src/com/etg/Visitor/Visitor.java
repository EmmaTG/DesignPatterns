package com.etg.Visitor;

public interface Visitor {
    double calculateCostChild(ChildPizza pizza);
    double calculateCostAdult(AdultPizza pizza);
    double calculateCostPensioner(PensionerPizza pizza);
}
