package com.etg.Mediator;

public class Dialog implements IMediator{
    TextBox firstname;
    TextBox lastname;
    TextBox pizzaName;
    CheckBox glutenfree;
    CheckBox confirm;
    CheckBox extraTopping;

    public Dialog() {
    }

    public void setConfirm(CheckBox confirm) {
        this.confirm = confirm;
    }

    public void setFirstname(TextBox firstname) {
        this.firstname = firstname;
    }

    public void setLastname(TextBox lastname) {
        this.lastname = lastname;
    }

    public void setPizzaName(TextBox pizzaName) {
        this.pizzaName = pizzaName;
    }

    public void setGlutenfree(CheckBox glutenfree) {
        this.glutenfree = glutenfree;
        this.glutenfree.hidden = false;
    }

    public void setExtraTopping(CheckBox extraTopping) {
        this.extraTopping = extraTopping;
    }

    @Override
    public void notify(Component component, String action) {
        if (component==this.firstname){
            System.out.println("Your first name is: " + action);
        }
        if (component==this.lastname){
            System.out.println("Your last name is: " + action);
        }
        if (component==this.pizzaName){
            System.out.println("You are ordering a " + action + " pizza");
        }

        if (component==this.glutenfree && this.glutenfree.isChecked) {
                System.out.println("You have requested a gluten free base");
                this.confirm.hidden = true;
            System.out.println("Please confirm this by 'clicking' the now visible check box");
        }

        if (component==this.extraTopping && this.extraTopping.isChecked) {
            System.out.println("You have requested EXTRA toppings");
        }
    }
}
