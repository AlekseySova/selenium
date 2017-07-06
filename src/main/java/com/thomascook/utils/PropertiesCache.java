package com.thomascook.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Alex Owl on 23.06.2017.
 */
public class PropertiesCache {

    private final Properties configProp = new Properties();
    private static final PropertiesCache INSTANCE = new PropertiesCache();

    private PropertiesCache(){

        System.out.println("Read all properties from file");
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("test.properties");
        try{

            configProp.load(in);

        }catch(IOException e){

            System.out.println("Can't read all properties from file. Expection: " + e);

        }

    }

    public static String getProperty(String key) {
        return INSTANCE.configProp.getProperty(key);
    }

}
