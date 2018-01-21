package com.github.spb.tget.data;

import com.github.spb.tget.utils.RandomUtils;

import org.apache.commons.lang3.RandomStringUtils;

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

    public static ListItemInfo randomListItemInfo() {
        return new ListItemInfo()
                .withName(RandomStringUtils.randomAlphanumeric(25))
                .withPrice(RandomUtils.getRandomDouble(1, 10000))
                .withAmount(RandomUtils.getRandomDouble(1, 100))
                .withComment(RandomStringUtils.randomAlphanumeric(25));
    }

    public static ListItemInfo randomWithListItemNamePrefix(String prefix) {
        return randomListItemInfo()
                .withName(prefix + RandomStringUtils.randomAlphanumeric(25));
    }
}
