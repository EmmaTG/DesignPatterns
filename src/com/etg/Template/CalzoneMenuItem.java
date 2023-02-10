package com.etg.Template;

import com.etg.Proxy.Recipe;

public class CalzoneMenuItem extends ProduceMenuItem{

    @Override
    protected Recipe collect_recipe() {
        return new Recipe("Calzone");
    }

    @Override
    protected void cook_item() {
        System.out.println("********* MAKING A CALZONE *********");
        System.out.println("Make a pizza then fold it in half and cook");
    }
}
