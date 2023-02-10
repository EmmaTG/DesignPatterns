package com.etg.Template;

import com.etg.Proxy.Recipe;

import java.util.Scanner;

public abstract class ProduceMenuItem {
    public void create_item(){
        specify_order();
        collect_recipe();
        cook_item();
        close_order();
    }

    protected String specify_order(){
        return null;
    }

    protected abstract Recipe collect_recipe();
    protected abstract void cook_item();
    protected void close_order(){
        System.out.println("Order is now closed. Ready for delivery!");
    }
}
