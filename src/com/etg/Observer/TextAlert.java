package com.etg.Observer;

public class TextAlert extends Alert implements IAlert{
    public TextAlert(Subscriber subscriber) {
        super(subscriber);
    }

    @Override
    public void sendAlert(String pizzaname) {
        System.out.println("Sending alert to " + this.subscriber.getName().toUpperCase() + " via TEXT \n about the new pizza called: " + pizzaname);
    }
}
