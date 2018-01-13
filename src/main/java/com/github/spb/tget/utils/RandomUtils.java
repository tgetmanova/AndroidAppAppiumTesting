package com.github.spb.tget.utils;

import com.github.spb.tget.data.ListItemInfo;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomUtils {
    private static long TICKS_AT_EPOCH = 621355968000000000L;

    private static Random random = new Random(System.currentTimeMillis() * 10000 + TICKS_AT_EPOCH);

    private static double getRandomDouble(double min, double max) {
        return (double) Math.round((min + (max - min) * random.nextDouble()) * 100000d) / 100000d;
    }

    public static String getRandomAlphanumeric(int charsCount) {
        return RandomStringUtils.randomAlphanumeric(charsCount);
    }

    public static ListItemInfo getRandomListItemInfo() {
        ListItemInfo listItemInfo = new ListItemInfo()
                .withName(RandomStringUtils.randomAlphanumeric(25))
                .withPrice(getRandomDouble(1, 10000))
                .withAmount(getRandomDouble(1, 100))
                .withComment(RandomStringUtils.randomAlphanumeric(25));

        return listItemInfo;
    }
}
