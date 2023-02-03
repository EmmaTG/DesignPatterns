package com.etg.Mediator;

public abstract class Component {

    IMediator dialog;
    String title;

    public Component(IMediator dialog,String title) {
        this.dialog = dialog;
        this.title = title;
    }

    public void processEvent(String event) {
        this.dialog.notify(this, event);
    }

}
