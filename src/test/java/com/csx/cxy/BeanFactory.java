package com.csx.cxy;

import com.csx.cxy.entity.User;

import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {


    public static Object getBean(String name){
        Object obj;
        try {
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            Class clazz = Class.forName(properties.getProperty(name));
            obj = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

}
