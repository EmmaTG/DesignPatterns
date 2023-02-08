package com.etg.Observer;

import java.util.ArrayList;
import java.util.Stack;

public class Subscriber implements ISubscriber{
    boolean phone;
    boolean text;
    boolean email;
    String name;
    IAlert notifier;

    public Subscriber(boolean phone, boolean text, boolean email, String name) {
        this.phone = phone;
        this.text = text;
        this.email = email;
        this.name = name;
        this.setAlerts();
    }

    public Subscriber(String name) {
        this(false, false, true, name);
    }

    // Decorator pattern: same interface for wrapper and wrappee
    private void setAlerts(){
        this.notifier = new Notifier();
        if (this.email) {
            this.notifier = new EmailAlert(this);
        }
        if (this.phone){
            this.notifier = new PhoneAlert(this);
        }
        if (this.text){
            this.notifier = new TextAlert(this);
        }
    }

    @Override
    public void updateSubscriber(String pizzaname) {
        this.notifier.sendAlert(pizzaname);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IAlert getNotifier() {
        return notifier;
    }
}
