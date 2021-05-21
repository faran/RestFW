package com.restapi.learn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    public static ConfigManager manager;
    public final static Properties prop = new Properties();


    private ConfigManager(){

        InputStream inputStream =
                ConfigManager.class.getResourceAsStream("/config.properties");
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigManager getInstance(){
        if(manager == null){
            synchronized (ConfigManager.class) {
                manager = new ConfigManager();
            }
        }
        return manager;
    }

    public String getString(String key){
        return System.getProperty(key, prop.getProperty(key));
    }
}
