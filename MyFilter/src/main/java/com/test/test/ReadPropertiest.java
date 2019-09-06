package com.test.test;


import org.junit.Test;

import javax.annotation.Resource;
import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ReadPropertiest {

    @Test
    public void read() throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("vocabulary");

//        String keyValue = new String(bundle.getKeys().getBytes("ISO-8859-1"), "GBK");
        Enumeration<?> enumeration = bundle.getKeys();
        while (enumeration.hasMoreElements()) {


            String o = (String) enumeration.nextElement();
            System.out.println(o+";"+bundle.getString(o));
        }
    }
}
