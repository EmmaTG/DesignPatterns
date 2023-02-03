package com.etg.Mediator;

public class TextBox extends Component{

    String input;

    public TextBox(IMediator dialog, String title) {
        super(dialog, title);
    }

    @Override
    public void processEvent(String event) {
        this.input = event;
        super.processEvent(event);
    }
}
