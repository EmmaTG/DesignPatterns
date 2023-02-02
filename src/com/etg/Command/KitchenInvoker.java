package com.etg.Command;

public class KitchenInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void completedTask(){
        this.command.execute();
    }
}
