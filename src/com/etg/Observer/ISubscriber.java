package com.etg.Observer;

public interface ISubscriber {
    void updateSubscriber(String pizzaname);
    String getName();
    public IAlert getNotifier();
}
