package com.etg.Command;

import com.etg.Builder.Pizza;

public class CookFood implements Command{

    Calzone calzone;

    public CookFood(Calzone calzone) {
        this.calzone = calzone;
    }

    @Override
    public void execute() {
        this.calzone.setCooked(true);
    }
}
