package com.training.task.module5.utils;

public class WaitUtils {

    public static void sleepSomeSecs() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException e) {
            Log.error("Thread is interrupted");
            e.printStackTrace();
        }
    }

}
