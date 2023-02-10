package com.etg.Template;

import com.etg.Proxy.Recipe;

public class SaladMenuItem extends ProduceMenuItem {

    @Override
    protected Recipe collect_recipe() {
        return null;
    }

    @Override
    protected void cook_item() {
        System.out.println("********* MAKING A SALAD *********");
        System.out.println("Nothing to cook!");
    }
}
