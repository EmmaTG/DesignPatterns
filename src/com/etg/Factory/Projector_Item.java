package com.etg.Factory;

// Factory: Concrete creator 2
public class Projector_Item extends IItem_Factory{
    @Override
    public IItem add_item() {
        System.out.println("Projector item factory created");
        this.item_type = "projector";
        return new Projector();
    }
}
