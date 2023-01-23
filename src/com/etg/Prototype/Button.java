package com.etg.Prototype;

public class Button extends HTMLElement {
    String sentence;

    public Button(){
    }

    public Button(Button target) {
        super(target);
        this.sentence = target.sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public HTMLElement clone() {
        return new Button(this);
    }

    @Override
    public String onClick() {
        return ", sentence: " +  this.sentence;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s;
    }
}
