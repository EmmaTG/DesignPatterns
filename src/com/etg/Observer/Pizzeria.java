package com.etg.Observer;

import java.util.ArrayList;

//PUBLISHER
public class Pizzeria {
    ArrayList<ISubscriber> subscribers;
    ArrayList<String> pizzas;

    public Pizzeria() {
        this.subscribers = new ArrayList<>();
        this.pizzas = new ArrayList<>();
    }

    public void newPizzaCreated(String pizzaName) {
        this.pizzas.add(pizzaName);
        this.notifySubscribers(pizzaName);
    }

    private void notifySubscribers(String pizzaName){
        for (ISubscriber s: subscribers){
            s.updateSubscriber(pizzaName);
        }
    }

    public void subscribe(ISubscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(ISubscriber subscriber){
        this.subscribers.remove(subscriber);
    }
}
