package com.github.spb.tget.data;

import com.github.spb.tget.utils.RandomUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Currency {
    POUND("£"),
    EURO("€"),
    DOLLAR("$");

    private String currencySymbol;

    Currency(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public static Currency getCurrencyBySymbol(String currencySymbol) {
        return Arrays.stream(Currency.values())
                .filter(c -> c.getCurrencySymbol().equals(currencySymbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown currency symbol: " + currencySymbol));
    }

    public static Currency getRandomCurrencyExcept(Currency exception) {
        return (Currency) RandomUtils.getRandomElement(
                Arrays.stream(Currency.values())
                        .filter(item -> !item.equals(exception))
                        .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return getCurrencySymbol();
    }
}
