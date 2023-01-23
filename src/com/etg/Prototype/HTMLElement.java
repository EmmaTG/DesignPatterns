package com.etg.Prototype;

public abstract class HTMLElement {
    int width;
    int height;
    String colour;

    public HTMLElement(){

    }

    public HTMLElement(HTMLElement target) {
        if (target != null){
            this.width = target.width;
            this.height = target.height;
            this.colour = target.colour;
        }
    }

    public abstract HTMLElement clone();

    public abstract String onClick();

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        String s = "width: " + this.width +
                    ", height: " + this.height +
                    ", colour: " + this.colour +
                ", " + this.onClick();
        return s;
    }
}
