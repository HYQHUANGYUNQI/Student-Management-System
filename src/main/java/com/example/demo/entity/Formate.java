package com.example.demo.entity;


import java.util.List;

public class Formate<T> {
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {

        this.total = total;
    }

    public List<T> getRows() {

        return rows;
    }

    public void setRows(List<T> rows) {

        this.rows = rows;
    }

    private List<T> rows;



}
