package com.wondersgroup.cd.etlgroup.utils;

import java.io.*;
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

        InputStream is = PropertiesReader.class.getClassLoader().getResourceAsStream("common.properties");

        try{
            commonProps.load(is);
        }catch(IOException e){
            //log here
            System.out.println(e.getMessage());
        }
    }

    public static String read(String key){
        System.out.println(key+"---"+commonProps.getProperty(key));
        return commonProps.getProperty(key);
    }

    public static String readTxtContent(String path) {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }

            br.close();
        }catch(IOException e){
            //log here
            e.printStackTrace();
        }

        return sb.toString();
    }
}
