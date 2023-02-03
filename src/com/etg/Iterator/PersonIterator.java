package com.etg.Iterator;

public class PersonIterator implements IPersonIterator {
    private PersonList list;
    private int current_position;
    private PERSONCATGEORY category;

    public PersonIterator(PersonList list, PERSONCATGEORY category) {
        this.list = list;
        this.current_position = -1;
        this.category = category;
    }

    @Override
    public Person getNext() {
        while (hasMore()){
            current_position++;
            Person person = list.listOfPeople.get(current_position);
            if (person.category == this.category){
                return person;
            }
        }
        return null;
    }

    @Override
    public boolean hasMore() {
        return current_position + 1 < list.listOfPeople.size();
    }
}
