package com.etg;

import com.etg.Builder.*;
import com.etg.Factory.*;
import com.etg.Prototype.Button;
import com.etg.Prototype.HTMLElement;
import com.etg.Prototype.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Prototype Code//
        ArrayList<HTMLElement> elements = new ArrayList<>();
        Button confirmButton = new Button();
        confirmButton.setColour("red");
        confirmButton.setHeight(2);
        confirmButton.setWidth(6);
        confirmButton.setSentence("Confirm choice on click");
        elements.add(confirmButton);

        Button confirmButton2 = (Button) confirmButton.clone();
        elements.add(confirmButton2);

        Table table1 = new Table();
        table1.setColour("pink");
        table1.setHeight(4);
        table1.setWidth(8);
        table1.setNumRows(2);
        table1.setNumColumns(4);
        table1.setDataSource("https://I.doNotKn.ow");
        elements.add(table1);

        Table table2 = (Table) table1.clone();
        elements.add(table2);

        for (HTMLElement element: elements){
            System.out.println(element.toString());
        }

//        // Builder Code //
//        PizzaDirector director = new PizzaDirector();
//        PizzaBuilder builder = new PizzaBuilder();
//
//        director.makeHawian(builder);
//        director.makeGlutenFree(builder);
//        director.makeSmall(builder);
//        Pizza pizza1 = builder.getPizza();
//
//        director.makeHawian(builder);
//        director.makeSmall(builder);
//        Pizza pizza2 = builder.getPizza();
//
//        director.makeDiavolo(builder);
//        director.makeLarge(builder);
//        Pizza pizza3 = builder.getPizza();
//
//        ArrayList<Pizza> orderedPizzas = new ArrayList<>();
//        orderedPizzas.add(pizza1);
//        orderedPizzas.add(pizza2);
//        orderedPizzas.add(pizza3);
//        for (Pizza pizza : orderedPizzas){
//            System.out.println(pizza.toString());
//        }


        // Factory code //
//        factoryClientCode client_code = new factoryClientCode();
//        // Add a computer
//        client_code.add_item("computer");
//        // Add a projector
//        client_code.add_item("projector");
//        // Add another projector
//        client_code.add_item("projector");
//        // Add another projector
//        client_code.add_item("projector");
//
//        System.out.println(client_code.print_inventory());
//
//        IItem item = client_code.checkOutItem("projector");
//        System.out.println(item.toString());
//        System.out.println(item.get_returned_time().toString());
//        System.out.println(client_code.print_inventory());
    }
}

class factoryClientCode {

    HashMap<String, ArrayList<IItem>> inventory;
    IItem_Factory item_factory = null;

    public factoryClientCode() {
        this.inventory = new HashMap<>();
    }

    void re_initialize() {
        this.inventory = new HashMap<>();
    }

    IItem checkOutItem(String type){
        IItem checked_out_item = null;
        ArrayList<IItem>  items = this.inventory.get(type);
        for (IItem item : items){
            if (!item.is_checked_out()){
                item.setCheckedOut(true);
                checked_out_item = item;
                configure_factory(type);
                this.item_factory.update_item(checked_out_item);
            }
        }
        return checked_out_item;
    }

    void configure_factory(String type) {
        switch (type) {
            case ("computer"):
                item_factory = new Computer_Item();
                break;
            case ("projector"):
                item_factory = new Projector_Item();
                break;
            default:
                System.out.println(type + " not supported in inventory");
                item_factory= null;
        }
    }

    void add_item(String type) {
        this.configure_factory(type);
        if (item_factory!=null) {
            IItem new_item = item_factory.create_item();
            String item_type = this.item_factory.getItem_type();
            ArrayList<IItem> items;
            if (this.inventory.containsKey(item_type)) {
                items = this.inventory.get(item_type);
            } else {
                items = new ArrayList<>();
            }
            items.add(new_item);
            this.inventory.put(item_type, items);
        }
        else {
            System.out.println("Could not create item " + type);
        }
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
                    double item_weight = item.getWeight();
                    weight += item_weight;
                }
            }
                s += "\t number available: " + num_available + ",\n";
               s += "\t total_stored_weight: " + weight + ",\n";
            }
        return s;
    }
}
