package com.github.spb.tget.data;

import java.util.Arrays;

public enum Currency {
    POUND("£"),
    EURO("€"),
    DOLLAR("$");

    private String currencySymbol;

    Currency(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencySymbol(){
        return currencySymbol;
    }

    public static Currency getCurrencyBySymbol(String currencySymbol){
        return Arrays.stream(Currency.values())
                .filter(c -> c.getCurrencySymbol().equals(currencySymbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown currency symbol: " + currencySymbol));
    }

    @Override
    public String toString(){
        return getCurrencySymbol();
    }
}
