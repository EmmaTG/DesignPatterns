package com.etg;

import com.etg.Factory.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


        // Factory code //
        Factory_Client_Code client_code = new Factory_Client_Code();
        // Add a computer
        client_code.add_item("computer");
        // Add a projector
        client_code.add_item("projector");
        // Add another projector
        client_code.add_item("projector");

        System.out.println(client_code.print_inventory());

        IItem item = client_code.checkOutItem("computer");
        System.out.println(item.toString());
        System.out.println(item.get_returned_time().toString());
        System.out.println(client_code.print_inventory());


    }
}

class Factory_Client_Code {

    HashMap<String, ArrayList<IItem>> inventory;
    IItem_Factory item_factory = null;

    public Factory_Client_Code() {
        this.inventory = new HashMap<>();
    }

    void re_initialize() {
        this.inventory = new HashMap<>();
    }

    IItem checkOutItem(String type){
        ArrayList<IItem>  items = this.inventory.get(type);
        for (IItem item : items){
            if (!item.is_checked_out()){
                item.setCheckedOut(true);
                return item;
            }
        }
        return null;
    }

    void configure_item(String type) {
        switch (type) {
            case ("computer"):
                item_factory = new Computer_Item();
                break;
            case ("projector"):
                item_factory = new Projector_Item();
                break;
            default:
                System.out.println(type + " not supported in inventory");
        }
    }

    void add_item(String type) {
        this.configure_item(type);
        IItem new_item = item_factory.create_item();
        String item_type = this.item_factory.getItem_type();
        ArrayList<IItem> items;
        if (this.inventory.containsKey(item_type)){
            items = this.inventory.get(item_type);
        } else {
            items = new ArrayList<>();
        }
        items.add(new_item);
        this.inventory.put(item_type,items);
    }

    String print_inventory(){
        String s = "\nInventory overview:\n\n".toUpperCase();
        Object entries;

        for (Map.Entry<String, ArrayList<IItem>> entry : this.inventory.entrySet()){
            s += entry.getKey() + ":\n";
            s += "\t number: " + entry.getValue().size() + ", \n";
            double weight = 0;
            int num_available = 0;
            for (IItem item : entry.getValue()) {
                if (!item.is_checked_out()){
                    num_available += 1;
                }
                double item_weight = item.getWeight();
                weight += item_weight;
            }
                s += "\t number available: " + num_available + ",\n";
               s += "\t total_weight: " + weight + ",\n";
            }
        return s;
    }
}
