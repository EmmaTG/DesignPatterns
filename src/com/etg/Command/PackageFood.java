package com.etg.Command;

public class PackageFood implements Command{

    Calzone calzone;

    public PackageFood(Calzone calzone) {
        this.calzone = calzone;
    }

    @Override
    public void execute() {
        this.calzone.setPackaged(true);
    }
}
