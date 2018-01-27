package com.github.spb.tget.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static long TICKS_AT_EPOCH = 621355968000000000L;

    private static Random random = new Random(System.currentTimeMillis() * 10000 + TICKS_AT_EPOCH);

    public static double getRandomDouble(double min, double max) {
        return (double) Math.round((min + (max - min) * random.nextDouble()) * 100000d) / 100000d;
    }

    public static String getRandomAlphanumeric(int charsCount) {
        return RandomStringUtils.randomAlphanumeric(charsCount);
    }

    public static Object getRandomElement(Collection collection) {
        int i = random.nextInt(collection.size());
        return collection.toArray()[i];
    }

    public static Boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public static List<String> getListOfRandomAlphanumerics(int count) {
        List<String> strings = new ArrayList<>(count);
        int i = 0;
        while (i++ < count) {
            strings.add(getRandomAlphanumeric(20));
        }
        return strings;
    }
}
