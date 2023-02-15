package com.etg;

import com.etg.Adapter.WeatherForecast;
import com.etg.Bridge.*;
import com.etg.Builder.*;
import com.etg.CoR.*;
import com.etg.Command.*;
import com.etg.Composite.*;
import com.etg.Composite.FrontOfHouse;
import com.etg.Decorator.BurntDecorator;
import com.etg.Decorator.CalzoneDecorator;
import com.etg.Decorator.IPizzaProduction;
import com.etg.Decorator.PizzaMaking;
import com.etg.Factory.*;
import com.etg.Fascade.OrderPizza;
import com.etg.Flyweight.SelfMadePizza;
import com.etg.Iterator.*;
import com.etg.Mediator.CheckBox;
import com.etg.Mediator.Dialog;
import com.etg.Mediator.TextBox;
import com.etg.Memento.Reservation;
import com.etg.Memento.ReservationSystem;
import com.etg.Memento.UndoCommand;
import com.etg.Observer.Pizzeria;
import com.etg.Observer.Subscriber;
import com.etg.Prototype.Button;
import com.etg.Prototype.HTMLElement;
import com.etg.Prototype.Table;
import com.etg.Proxy.Recipe;
import com.etg.Proxy.RecipeCache;
import com.etg.Proxy.RecipeManager;
import com.etg.Proxy.RecipeStore;
import com.etg.Singleton.Singleton;
import com.etg.State.Oven;
import com.etg.Strategy.CorrectMethod;
import com.etg.Strategy.IncorrectMethod;
import com.etg.Strategy.KitchenContext;
import com.etg.Template.CalzoneMenuItem;
import com.etg.Template.PizzaMenuItem;
import com.etg.Template.ProduceMenuItem;
import com.etg.Template.SaladMenuItem;
import com.etg.Visitor.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // BEHAVIORAL PATTERNS //
//        chain_of_responsibility_pattern(); // Pass along requestion for sequential or canonical handling
//        command_pattern(); // Turns request into an object allows for request passign on, delaying or timed execution
//        iterator_pattern(); // Traverse collection without exposing representation
//        mediator_pattern(); // Reduce object dependencies. Communicate vua mediator, not eachother
//        memento_pattern(); // Save and restore previous states
//        observer_pattern(); // subscription mechanism
//        state_pattern(); // alter behaviour with internal state change
//        strategy_pattern(); // put family of algorithms into separate classes
//        template_pattern(); // Defines algorithm skeleton, subclass overwrite allowed
//        visitor_pattern(); // separate alogrithm from objects on which they operate

        // STRUCTURAL PATTERNS //
//        adapter_pattern(); // Allows objects with incompatible interfaces to collaborate
//        bridge_pattern(); // SPlit large classes into abstraction and implementation
//        composite_pattern(); // Create tree sturctures
//        decorator_pattern(); // Attach new behaviours to objects inside special wrapper objects
//        facade_pattern(); //simplified interface for complex classes,framework or library
//        fly_weight_pattern(); // Ram space optimization
//        proxy_pattern(); // Provide placeholder for another object

        // CREATIONAL DESIGN PATTERNS //
//        factory_pattern(); // Create objects in superclass via factory method
//        builder_pattern(); // Create complex objects step by step. No monsterous constructors
//        prototype_pattern(); // Create copy of object without code being dependent on their classes
//        singleton_pattern(); // Only want one instance of a class (e.g. a database)
    }
    public static void visitor_pattern(){
        // separate algorithms from the objects on which they operate.
        // Create algorithm as a class (VISITOR) and pass object onto which you want to perform the algorithm into the Visitor
        // Use double dispatch to find out what type of object it is, delegate this to the object itself via accept method
        CostCalculator costCalculator = new CostCalculator();
        ArrayList<Element> customersOrder = new ArrayList<>();
        ChildPizza pizza1 = new ChildPizza();
        ChildPizza pizza2 = new ChildPizza();
        pizza2.addExtraCheese();
        AdultPizza pizza3 = new AdultPizza(30,"Salami");
        pizza3.addTopping("Artichokes");
        pizza3.addTopping("Olives");
        AdultPizza pizza4 = new AdultPizza(30, "Tomatoes");
        PensionerPizza pizza5 = new PensionerPizza(20);
        customersOrder.add(pizza1);
        customersOrder.add(pizza2);
        customersOrder.add(pizza3);
        customersOrder.add(pizza4);
        customersOrder.add(pizza5);
        double orderAmount = 0;
        double pizzaCost;
        for (Element e : customersOrder){
            pizzaCost = e.accept(costCalculator);
            System.out.println("Pizza " + e + "\n\tcosts " + pizzaCost);
            orderAmount += pizzaCost;
        }
        System.out.println("Total order costs: " + orderAmount);
    }

    public static void template_pattern(){
        //Define skeleton of algoirthm in superclass, with ability for sub classes to override them
        // Break down algorithm into steps->turn in to methods and put series calls to these methods inside template method
        ArrayList<ProduceMenuItem> orderedItems = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean orderMore = true;
        while (orderMore) {
            ProduceMenuItem item = null;
            System.out.println("What would you like to order:");
            while (true) {
                System.out.println("1. Pizza");
                System.out.println("2. Calzone");
                System.out.println("3. Salad");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        item = new PizzaMenuItem();
                        break;
                    case 2:
                        item = new CalzoneMenuItem();
                        break;
                    case 3:
                        item = new SaladMenuItem();
                        break;
                    default:
                        System.out.println("Sorry that is not an available option, please pick again.");
                }
                if (item != null){
                    break;
                }
            }
            orderedItems.add(item);

            System.out.println("Would you like to order something else: y|n");
            String answer = scanner.nextLine();
            orderMore = answer.toLowerCase().equals("y");
        }
        for (ProduceMenuItem item : orderedItems){
            item.create_item();
        }
    }

    public static void strategy_pattern(){
        // define family of algorithms (do something specific in a lot of ways) and put each in separate class call STRATEGIES
        // Context class stores reference to one strategy and executes it. Context doesn't know/care what type of strategy it is
        // Type of strategy is passed in via client
        KitchenContext kitchen = new KitchenContext();
        kitchen.setMethod(new CorrectMethod());
        System.out.println("How to build a pizza correctly");
        System.out.println("------------------------------");
        kitchen.buildPizza();
        System.out.println();
        System.out.println("How to do it all wrong!!");
        System.out.println("------------------------");
        kitchen.setMethod(new IncorrectMethod());
        kitchen.buildPizza();
    }

    public static void state_pattern(){
        //  lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.
        // Avoid situation of many many if statements
        Oven oven = new Oven();
        oven.turnOffOven();
        oven.openOvenDoor();
        oven.turnOnOven();

        oven.turnOffOven();
        oven.turnOnOven();
        oven.openOvenDoor();
        oven.ovenPreheated();
        oven.openOvenDoor();
        oven.turnOnOven();
        oven.putPizzaInOven();
        oven.turnOffOven();
        oven.turnOnOven();
        oven.putPizzaInOven();
        oven.pizzaCooked();
        oven.turnOnOven();
        oven.turnOffOven();
        oven.openOvenDoor();
        oven.removePizza();
        oven.turnOffOven();
        oven.openOvenDoor();
        oven.turnOnOven();

    }

    public static void observer_pattern(){
        // Subscription mechanism
        // PUBLISHER: object with interesting state that it will notify SUBSCRIBERS about
        // SUBSCRIBERS: objects that want to track state of PUBLISHER

        Pizzeria restaurant = new Pizzeria();
        restaurant.subscribe(new Subscriber(true,false,true,"Emma"));
        restaurant.subscribe(new Subscriber("Daniel"));
        restaurant.subscribe(new Subscriber(true,true,true,"Dad"));
        restaurant.subscribe(new Subscriber(false, false, false,"Mom"));
        restaurant.newPizzaCreated("Spezial");
    }

    public static void memento_pattern(){
        // save and restore the previous state of an object without revealing the details of its implementation.
        // Originator creates the snapshots, memento acts as snap shot, caretaker only knows when and why snapshot was created
        // Often used with Command pattern to implement the Undo action
        History history = new History(); // RECEIVER
        UndoCommand commands = new UndoCommand(history); //CONCRETE COMMAND
        ReservationSystem system = new ReservationSystem(history, commands); //INVOKER
        system.addReservation(new Reservation("Emma", new Date(), 4));
        System.out.println("--------------------Added one reservation--------------------");
        System.out.println(system);
        system.save();
        system.addReservation(new Reservation("Emma1", new Date(), 8));
        system.addReservation(new Reservation("Emma2", new Date(), 12));
        system.addReservation(new Reservation("Emma3", new Date(), 1));
        System.out.println("--------------------Added three reservations--------------------");
//        system.createSnapshot();
        System.out.println(system);
        system.undo();
        System.out.println(system);
//        system.save();
        system.addReservation(new Reservation("Emma1", new Date(), 18));
        system.addReservation(new Reservation("Emma2", new Date(), 22));
        system.addReservation(new Reservation("Emma3", new Date(), 11));
        System.out.println("--------------------Added three reservations--------------------");
        System.out.println(system);
        system.undo();
        System.out.println(system);
    }

    public static void mediator_pattern(){
        // reduce chaotic dependencies between objects. The pattern restricts direct communications between
        // the objects and forces them to collaborate only via a mediator object.
        // Mediate redirects calls to the appropriate components (Objects doesn't do the work, it just sends a message to the mediator
        // that it is now ready to have the work done/ notify mediator to notify other components)

        Dialog dialogBox = new Dialog(); // Concrete mediator
        TextBox firstname = new TextBox(dialogBox,"First name"); // Component
        dialogBox.setFirstname(firstname); // Registration of component with mediator
        TextBox lastname = new TextBox(dialogBox,"Last name");
        dialogBox.setLastname(lastname);
        TextBox pizzaName = new TextBox(dialogBox,"Type of Pizza?");
        dialogBox.setPizzaName(pizzaName);
        CheckBox glutenfree = new CheckBox(dialogBox, "Gluten free base?");
        dialogBox.setGlutenfree(glutenfree);
        CheckBox comfirmChoice = new CheckBox(dialogBox, "Are you sure!!");
        dialogBox.setConfirm(comfirmChoice);
        CheckBox extraTopping = new CheckBox(dialogBox,"Extra toppings?");
        dialogBox.setExtraTopping(extraTopping);


        firstname.processEvent("Emma"); // Action performed on component sent to mediator (dialog) to utilize. Component merely send message along
        lastname.processEvent("Griffiths");
        pizzaName.processEvent("Hawaian");
        glutenfree.processEvent("y");
    }

    public static void iterator_pattern(){
        // lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).
        // iterates through general list fo everyone to iterate only customers of only staff
        PersonList listOfPeople = new PersonList(); // Collection
        listOfPeople.addPerson(new Person("Emma", "0123456789", PERSONCATGEORY.STAFF));
        listOfPeople.addPerson(new Person("Daniel", "0123456789", PERSONCATGEORY.STAFF));
        listOfPeople.addPerson(new Person("Robyn", "0123456789", PERSONCATGEORY.STAFF));
        listOfPeople.addPerson(new Person("Rowan", "0123456789", PERSONCATGEORY.CUSTOMER));
        listOfPeople.addPerson(new Person("Thomas", "0123456789", PERSONCATGEORY.CUSTOMER));
        listOfPeople.addPerson(new Person("Karen", "0123456789", PERSONCATGEORY.STAFF));
        listOfPeople.addPerson(new Person("Richard", "0123456789", PERSONCATGEORY.STAFF));
        listOfPeople.addPerson(new Person("Louise", "0123456789", PERSONCATGEORY.CUSTOMER));
        listOfPeople.addPerson(new Person("Justin", "0123456789", PERSONCATGEORY.CUSTOMER));
        listOfPeople.addPerson(new Person("Eva", "0123456789", PERSONCATGEORY.CUSTOMER));
        listOfPeople.addPerson(new Person("Alison", "0123456789", PERSONCATGEORY.STAFF));
        listOfPeople.addPerson(new Person("Simon", "0123456789", PERSONCATGEORY.CUSTOMER));

        System.out.println("List fo Staff");
        IPersonIterator staffIterator = listOfPeople.createStaffIterator(); // Selecting method to traverse (i.e. via staff)
        while (staffIterator.hasMore()){ // Traverse list finding staff
            System.out.println(staffIterator.getNext());
        }


        System.out.println("List fo Customers");
        IPersonIterator customerIterator = listOfPeople.createCustomerIterator();
        while (customerIterator.hasMore()){
            System.out.println(customerIterator.getNext());
        }
    }

    public static void command_pattern(){
        // Turns request into stand alone object containing all the information. Pass requests as method arguments
        // Separation of concern, breaking things into layers
        KitchenInvoker invoker = new KitchenInvoker(); // INVOKER (button or switch to be pressed ONLY when necessary/ready)
        Calzone calzone = new Calzone("Plain"); // RECEIVER (the item upon which the commands are executed)
        Command cookFood = new CookFood(calzone); // CONCRETE COMMAND 1 (the concrete command to be done to the receiver BUT only when the invoker is 'invoked')
        Command packageFood = new PackageFood(calzone); // CONCRETE COMMAND 2

        System.out.println(calzone.toString());
        invoker.setCommand(cookFood);
        invoker.completedTask();
        System.out.println(calzone.toString());
        invoker.setCommand(packageFood);
        invoker.completedTask();
        System.out.println(calzone.toString());
    }

    public static void chain_of_responsibility_pattern() {
        // pass requests along a chain of handlers. each handler decides to process or pass on
        // Canonical -> move along handlers until we find the right one
        // Sequential -> execute every handler until there's a problem on one (e.g authentication->authorization,->validation)

        // Canonical
        com.etg.CoR.FrontOfHouse foH = new com.etg.CoR.FrontOfHouse();
        Kitchen kitchen = new Kitchen();
        DeliveryPartner uber = new DeliveryPartner();
        Nondescript manager = new Nondescript();
        foH.addNextHandler(kitchen);
        kitchen.addNextHandler(uber);
        uber.addNextHandler(manager);

        Complaint complaint1 = new Complaint(CATEGORY.CUSTOMER_SERVICE, "Person taking my order was very rude");
        Complaint complaint2 = new Complaint(CATEGORY.COOKING, "Pizza was gross");
        Complaint complaint3 = new Complaint(CATEGORY.OTHER, "Restaurant was TOO loud!");
        Complaint complaint4 = new Complaint(CATEGORY.PACKAGING, "Packaging was weak");
        Complaint complaint5 = new Complaint(CATEGORY.DELIVERY, "Pizza was cold");
        foH.logComplaint(complaint1);
        foH.logComplaint(complaint2);
        foH.logComplaint(complaint3);
        foH.logComplaint(complaint4);
        foH.logComplaint(complaint5);
        System.out.println("Total number of complaints: " + foH.getNumberOfComplaints());

    }

    public static void proxy_pattern() {
        // Lets you provide a substitute or placeholder for another object (while waiting for object to arrive)
        // Proxy disguises itself as the real object (using service interface)
        // Functions like a cache service
        RecipeStore storeOfRecipes = new RecipeStore();
        RecipeCache cachedRecipes = new RecipeCache(storeOfRecipes);
        RecipeManager manager = new RecipeManager(cachedRecipes);
        System.out.println(manager.findRecipe("Vegetarian").toString());
        ArrayList<String> ingredients = manager.getRecipeIngredients("Vegetarian");
        for (String i : ingredients){
            System.out.println(i);
        }
        ArrayList<Recipe> recipes = manager.getAllRecipes();
        for (Recipe r : recipes){
            System.out.println(r.toString());
        }
        System.out.println(manager.findRecipe("Vegetarian").toString());
    }

    public static void fly_weight_pattern() {
        // Lets you fit more objects into the available RAM
        // Split data into intrinsic (lives in the object, cannot be changed) and extrinsic (altered by outside objects)
        // Flyweight should be immutable, can use factory to manage flyweigth objects
        int PIZZASIZE=20;
        SelfMadePizza pizza = new SelfMadePizza();
        for (int i =0; i<200; i++){
            pizza.addCheese(random(0, PIZZASIZE),random(0, PIZZASIZE));
        }
        for (int i =0; i<100; i++){
            pizza.addHam(random(0, PIZZASIZE),random(0, PIZZASIZE));
        }
        for (int i =0; i<5; i++){
            pizza.addTruffle(random(0, PIZZASIZE),random(0, PIZZASIZE));
        }

        System.out.println("Cost of pizza: " + (short) pizza.costOfPizza());

    }
    private static double random(double min, double max) {
        return min + ((Math.random() * ((max - min) + 1)));
    }


    public static void facade_pattern() {
        //provides a simplified interface to complex stuff.
        // Only gives access to features client really cares about or give client access to a tiny bit of functionality within a complex library
        OrderPizza order = new OrderPizza("Basic", "22 Main avenue");
        order.placeOrder();
    }

    public static void decorator_pattern() {
        // Attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors
        // Allows change/addition of behaviours AT runtime (unlike inheritance would)
        // Using aggregation (A contains B, B and live without A)

        IPizzaProduction pizzaProduction = new PizzaMaking();
        pizzaProduction.assemble();
        pizzaProduction.cook();
        System.out.println();

        pizzaProduction = new CalzoneDecorator(pizzaProduction);
        pizzaProduction.assemble();
        pizzaProduction.cook();
        System.out.println();

        pizzaProduction = new BurntDecorator(pizzaProduction);
        pizzaProduction.assemble();
        pizzaProduction.cook();
        System.out.println();
    }

    public static void composite_pattern() {
        // The pizza delivery process from ordering to delivering
        ArrayList<IDivision> divisions = new ArrayList<>();
        ArrayList<IDivision> buildingSubdivisions = new ArrayList<>();

        divisions.add(new FrontOfHouse());

        buildingSubdivisions.add(new GatherIngredients());
        buildingSubdivisions.add(new Preparation());
        Assembly building = new Assembly(buildingSubdivisions);

        PizzaProduction production = new PizzaProduction();
        production.addDivision(building);
        production.addDivision(new Cooking());
        divisions.add(production);

        divisions.add(new Delivery());

        for (IDivision div : divisions){
            div.workToBeDone();
        }
    }

    public static void bridge_pattern() {
        //  split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation
        //  Allows two things to vary independently, although they depend on each other
        // Example: A workshop [abstraction] (that can vary and be advanced) that works on different vehicles [implementors]

        Vehicle brokenCar = new Car();
        fixVehicle(brokenCar);
        Vehicle brokenBike = new Bike();
        fixVehicle(brokenBike);
    }

    public static void fixVehicle(Vehicle vehicle){
        Workshop workshop = new Workshop(vehicle);
        System.out.println(workshop.work());
        System.out.println("Cost of work: " + workshop.getCost());
        System.out.println();

        AdvancedWorkshop advancedWorkshop = new AdvancedWorkshop(vehicle);
        advancedWorkshop.workQuickly();
        System.out.println(advancedWorkshop.work());
        System.out.println("Cost of work: " + advancedWorkshop.getCost());
        System.out.println();
    }

    public static void adapter_pattern(){
        // Allows objects with incompatible interfaces to collaborate.
        // 'Adapts' imperial units to metric
        WeatherForecast forecast = new WeatherForecast();
        System.out.println("IMPERIAL WEATHER FORECAST");
        System.out.println(forecast.whatsTheWeather("IMPERIAL"));
        System.out.println("METRIC WEATHER FORECAST");
        System.out.println(forecast.whatsTheWeather("METRIC"));
    }

    public static void singleton_pattern(){
        //        // Singleton Code
        // Must: 1. Only have oen instance AND 2. Be globally accessible
        // Uses: logging, caching, db accessing
        Singleton singleton = Singleton.getInstance("Foo");
        Singleton singleton2 = Singleton.getInstance("Bar");
        System.out.println(singleton.value);
        System.out.println(singleton2.value);
    }

    public static void prototype_pattern(){
        //        // Prototype Code//
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
    }

    public static void builder_pattern(){
        //        // Builder Code //
        PizzaDirector director = new PizzaDirector();
        PizzaBuilder builder = new PizzaBuilder();

        director.makeHawian(builder);
        director.makeGlutenFree(builder);
        director.makeSmall(builder);
        Pizza pizza1 = builder.getPizza();

        director.makeHawian(builder);
        director.makeSmall(builder);
        Pizza pizza2 = builder.getPizza();

        director.makeDiavolo(builder);
        director.makeLarge(builder);
        Pizza pizza3 = builder.getPizza();

        ArrayList<Pizza> orderedPizzas = new ArrayList<>();
        orderedPizzas.add(pizza1);
        orderedPizzas.add(pizza2);
        orderedPizzas.add(pizza3);
        for (Pizza pizza : orderedPizzas){
            System.out.println(pizza.toString());
        }
    }

    public static void factory_pattern(){
        // Factory code //
        factoryClientCode client_code = new factoryClientCode();
        // Add a computer
        client_code.add_item("computer");
        // Add a projector
        client_code.add_item("projector");
        // Add another projector
        client_code.add_item("projector");
        // Add another projector
        client_code.add_item("projector");

        System.out.println(client_code.print_inventory());

        IItem item = client_code.checkOutItem("projector");
        System.out.println(item.toString());
        System.out.println(item.get_returned_time().toString());
        System.out.println(client_code.print_inventory());
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
