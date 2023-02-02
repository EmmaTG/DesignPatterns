package com.etg.Command;

public class Calzone {

    String name;
    boolean isCooked;
    boolean isPackaged;

    public Calzone(String name) {
        this.name = name;
        this.isCooked = false;
        this.isPackaged = false;
    }

    public boolean isPackaged() {
        return isPackaged;
    }

    public void setPackaged(boolean packaged) {
        isPackaged = packaged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCooked() {
        return isCooked;
    }

    public void setCooked(boolean cooked) {
        isCooked = cooked;
    }

    @Override
    public String toString() {
        return "Calzone{" +
                "name='" + name + '\'' +
                ", isCooked=" + isCooked +
                ", isPackaged=" + isPackaged +
                '}';
    }
}
