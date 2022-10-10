package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String readProperty(String key){
        //File class assign given file to the java object
        File file=new File("configuration.properties");
        Properties properties=new Properties();
        //properties object  will read the properties file
        try {
            properties.load(new FileInputStream(file));
            //load method will load every value from file
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        //more actions surround by try and catch
        return properties.getProperty(key);
        /*
        1-url, username, password into configuration.properties
         */
    }
}
