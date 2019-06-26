package com.training.task.module5.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHandler {

    private static PropertyHandler instance;
    private Properties prop;

    private PropertyHandler(){
        try (InputStream input = new FileInputStream("src/test/resources/test.properties")) {
            prop = new Properties();
            this.prop.load(input);
        } catch (IOException ex) {
            Log.error("Failed to read data from properties file");
            ex.printStackTrace();
        }
    }

    private static PropertyHandler init() {
        if (instance == null) {
            instance = new PropertyHandler();
        }
        return instance;
    }

    public static String getTestUrl() {
        return init().prop.getProperty("testUrl");
    }

    public static Credentials getCredentials() {
        String user = init().prop.getProperty("userEmail");
        String password = init().prop.getProperty("userPassword");
        return new Credentials(user, password);
    }



}
