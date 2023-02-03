package com.etg.Iterator;

import java.util.ArrayList;

public class PersonList implements IPersonList {

    ArrayList<Person> listOfPeople;

    public PersonList() {
        this.listOfPeople = new ArrayList<>();
    }

    public void addPerson(Person person){
        this.listOfPeople.add(person);
    }

    @Override
    public IPersonIterator createCustomerIterator() {
        return new PersonIterator(this, PERSONCATGEORY.CUSTOMER);
    }

    @Override
    public IPersonIterator createStaffIterator() {
        return new PersonIterator(this, PERSONCATGEORY.STAFF);
    }
}
