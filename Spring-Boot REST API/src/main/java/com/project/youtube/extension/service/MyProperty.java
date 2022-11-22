package com.project.youtube.extension.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperty {
    public static Properties propertyObject()
    {
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            return prop;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
