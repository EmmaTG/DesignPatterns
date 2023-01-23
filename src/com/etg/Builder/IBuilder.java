package com.etg.Builder;

public interface IBuilder {
    public void reset();
    public void setSize(SizeType size);
    public void makeBase(String base);
    public void addSauce(String sauce);
    public void addTopping(String top);
    public void setBaseCost(double cost);

}
