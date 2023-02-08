package com.etg.Observer;

import java.util.ArrayList;
import java.util.Stack;

public class Subscriber implements ISubscriber{
    boolean phone;
    boolean text;
    boolean email;
    String name;
    ArrayList<Alert> alerts;

    public Subscriber(boolean phone, boolean text, boolean email, String name) {
        this.phone = phone;
        this.text = text;
        this.email = email;
        this.name = name;
        this.alerts = new ArrayList<>();
        this.setAlerts();
    }

    public Subscriber(String name) {
        this(false, false, true, name);
    }

    private void setAlerts(){
        if (this.email) {
            this.alerts.add(new EmailAlert(this));
        }
        if (this.phone){
            this.alerts.add(new PhoneAlert(this));
        }
        if (this.text){
            this.alerts.add(new TextAlert(this));
        }
    }

    @Override
    public void updateSubscriber(String pizzaname) {
        if (this.alerts.isEmpty()){
            System.out.println("No alerts set up for " + this.name.toUpperCase());
        }
        for (Alert a : this.alerts){
            a.sendAlert(pizzaname);
        }
    }

    public String getName() {
        return name;
    }
}
