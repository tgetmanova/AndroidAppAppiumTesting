package com.github.spb.tget.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public final class RandomUtils {
    private static long TICKS_AT_EPOCH = 621355968000000000L;

    private static Random random = new Random(System.currentTimeMillis() * 10000 + TICKS_AT_EPOCH);

    private RandomUtils() {
        throw new IllegalStateException("RandomUtils class is for static utils only and must not be instantiated");
    }

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

    public static int getRandomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
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
