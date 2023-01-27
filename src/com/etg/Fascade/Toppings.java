package com.etg.Fascade;

public class Toppings {

    public void collectTopping(String pizza){
        if (pizza.equals("Basic")){
            System.out.println("Collect cheese, tomato and basil");
        } else {
            System.out.println("Collect all others toppings");
        }
    }
}
