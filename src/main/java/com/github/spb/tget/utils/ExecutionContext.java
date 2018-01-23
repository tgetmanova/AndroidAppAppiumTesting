package com.github.spb.tget.utils;

public class ExecutionContext {
    private static final int DEFAULT_ATTEMPTS_COUNT = 3;
    private static final int DEFAULT_INTERVAL_IN_MILLISECONDS = 3000;

    public static void executeForSuccess(Runnable action) {
        executeForSuccess(action, DEFAULT_ATTEMPTS_COUNT, DEFAULT_INTERVAL_IN_MILLISECONDS);
    }

    public static void executeForSuccess(Runnable action, int attemptsCount, long sleepIntervalInMillis) {
        Throwable targetException = null;
        for (int i = 0; i < attemptsCount; i++) {
            try {
                action.run();
                return;
            } catch (Throwable throwable) {
                targetException = throwable;
            }
            try {
                Thread.sleep(sleepIntervalInMillis);
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }

        throw new AssertionError(String.format("Cannot perform action successfully " +
                        "after %d attempts with %d millis interval: %s ",
                attemptsCount, sleepIntervalInMillis, targetException.getMessage()));
    }
}
