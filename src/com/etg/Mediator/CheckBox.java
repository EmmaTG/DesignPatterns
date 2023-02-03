package com.etg.Mediator;

public class CheckBox extends Component{

    boolean isChecked;
    boolean hidden;

    public CheckBox(IMediator dialog, String title) {
        super(dialog, title);
        this.isChecked = false;
        this.hidden = true;
    }

    @Override
    public void processEvent(String event) {
        if (event.toLowerCase().equals("y")){
            this.isChecked = true;
        } else {
            this.isChecked = false;
        }
        super.processEvent(event);
    }
}
