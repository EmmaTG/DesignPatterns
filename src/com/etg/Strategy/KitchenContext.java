package com.etg.Strategy;

import java.util.ArrayList;

public class KitchenContext {
    Method method;

    public void setMethod(Method method){
        this.method = method;
    }

    public void buildPizza(){
        if (this.method != null){
            ArrayList<String> howToBuildAPizza = method.buildPizza();
            for (String step : howToBuildAPizza){
                System.out.println(step);
            }
        }
        else {
            System.out.println("No method has been selected");
        }
    }
}
