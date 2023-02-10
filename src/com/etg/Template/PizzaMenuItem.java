package com.etg.Template;

import com.etg.Proxy.Recipe;

import java.util.Scanner;

public class PizzaMenuItem extends ProduceMenuItem {
    private String pizzaType;

    @Override
    protected  String specify_order() {
        super.specify_order();
        this.pizzaType = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of pizza would you like:");
        while(true) {
            System.out.println("1. Plain");
            System.out.println("2. Hawaian");
            System.out.println("3. Diavolo");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    this.pizzaType = "Plain";
                    break;
                case 2:
                    this.pizzaType ="Hawaian";
                    break;
                case 3:
                    this.pizzaType = "Diavolo";
                    break;
                default:
                    System.out.println("Sorry that is not an available option, please pick again.");
            }
            if (this.pizzaType != null){
                break;
            }
        }
        return this.pizzaType;
    }

    @Override
    protected Recipe collect_recipe() {
        Recipe recipe = new Recipe(this.pizzaType);
        return recipe;
    }

    @Override
    protected void cook_item() {
        System.out.println("********* MAKING A " + this.pizzaType.toUpperCase() + " PIZZA *********");
        System.out.println("Roll out dough, cover with sauce and cheese, add toppings, place in wood fired oven");
    }
}
