package com.etg.Factory;

// Factory: Concrete creator 1
public class Computer_Item extends IItem_Factory{
    @Override
    public IItem add_item() {
        System.out.println("Computer item factory created");
        this.item_type = "computer";
        return new Computer();
    }
}
