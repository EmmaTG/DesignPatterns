package com.etg.Factory;

import java.util.ArrayList;
import java.util.Date;

//Factory: Base creator
public abstract class IItem_Factory {
    String item_type;

    // Should also have some core business logic in factory method
    public IItem create_item(){
        // Business logic e.g.:
            // Add item to database
            // Use info from item to add to/ alter item before sendign it out
        return this.add_item();
    }

    public boolean update_item(IItem item){
        // Update item in db
        return true;
    }

    public abstract IItem add_item();

    public String getItem_type(){
        return this.item_type;
    }


}
