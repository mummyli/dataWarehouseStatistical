package com.wondersgroup.cd.etlgroup.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lsj on 2017-7-18.
 */
public class PropertiesReader {

    private static Properties commonProps = new Properties();

    static {
        loads();
    }

    public static void loads(){
        InputStream is = PropertiesReader.class.getResourceAsStream("/common.properties");


        try{
            commonProps.load(is);
        }catch(IOException e){
            //log here
        }
    }

    public static String read(String key){
        return commonProps.getProperty(key);
    }
}
