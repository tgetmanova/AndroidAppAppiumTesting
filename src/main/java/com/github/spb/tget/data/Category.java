package com.github.spb.tget.data;

import com.github.spb.tget.utils.RandomUtils;

import java.util.Arrays;

public enum Category {
    GROCERY("Grocery"),
    DAIRY("Dairy produce"),
    PETS("Pets roducts"),
    ACCESS_GROCERY("Accessories Grocery"),
    CHILD("Childs products"),
    MEDIC("Medications"),
    STATIONERY("Stationery"),
    COSMETIC("Cosmetic, hygiene"),
    SPORT("Sporting goods, games"),
    ACCESS("Accessories"),
    CLOTH("Clothing, footwear"),
    AUTO("Auto products"),
    PLANTS("Plants"),
    MEAT("Meat, fish, eggs"),
    DRINKS("Drinks, juices"),
    PASTRY("Bread, cakes and pastries");

    private String name;

    public String getName() {
        return name;
    }

    Category(String name) {
        this.name = name;
    }

    public static Category random() {
        return (Category) RandomUtils.getRandomElement(Arrays.asList(Category.values()));
    }
}
