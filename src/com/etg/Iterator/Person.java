package com.etg.Iterator;

public class Person {

    int id;
    String name;
    String phoneNo;
    PERSONCATGEORY category;

    public Person(String name, String phoneNo, PERSONCATGEORY category) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", category=" + category +
                '}';
    }
}
