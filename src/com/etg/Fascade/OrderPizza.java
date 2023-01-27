package com.etg.Fascade;

public class OrderPizza {
    private String pizza;
    private String address;

    public OrderPizza(String pizza, String address) {
        this.pizza = pizza;
        this.address = address;
    }

    public void placeOrder(){
        Dough dough = new Dough();
        dough.makeDough();
        Sauce sauce = new Sauce();
        sauce.makeSauce();
        Toppings toppings = new Toppings();
        toppings.collectTopping(this.pizza);
        System.out.println("Assemblt pizza dough, sauce and toppings");
        Cook cook = new Cook();
        cook.cookPizza();
        Delivery delivery = new Delivery(this.address);
        delivery.deliverFood();
        System.out.println("Order placed, cooked and delivered");
    }
}
