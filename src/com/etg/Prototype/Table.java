package com.etg.Prototype;

public class Table extends HTMLElement{
    int numRows;
    int numColumns;
    String dataSource;

    public Table(){
    }

    public Table(Table target) {
        super(target);
        this.numRows = target.numRows;
        this.numColumns = target.numColumns;
        this.dataSource = target.dataSource;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public HTMLElement clone() {
        return new Table(this);
    }

    @Override
    public String onClick() {
        String s = ", This table has " + this.numRows + " rows and " + this.numColumns + " columns from data source: " + this.dataSource;
        return s;
    }



    @Override
    public String toString() {
        String s = super.toString();
        return s;
    }
}
