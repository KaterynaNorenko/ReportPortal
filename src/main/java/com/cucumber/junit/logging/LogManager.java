package com.cucumber.junit.logging;

import java.util.logging.Logger;

public class LogManager {

    private static final Logger logger = LogManager.getLogger();

    public static Logger getLogger() {
        return logger;
    }
}
