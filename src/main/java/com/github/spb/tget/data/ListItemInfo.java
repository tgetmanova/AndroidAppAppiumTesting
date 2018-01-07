package com.github.spb.tget.data;

public class ListItemInfo {

    private String name;
    private String comment;
    private double price;
    private double amount;

    public String getName() {
        return name;
    }

    public ListItemInfo withName(String name) {
        this.name = name;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ListItemInfo withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ListItemInfo withPrice(double price) {
        this.price = price;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public ListItemInfo withAmount(double amount) {
        this.amount = amount;
        return this;
    }
}
