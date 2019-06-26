package com.training.task.module5.utils;

import org.apache.log4j.Logger;

public class Log {

    public static Logger logger = Logger.getLogger(Log.class);

    public static void error(String message) {
        logger.error(message);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

}
