package com.pigcanfly.test;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author tobbyquinn
 * @date 2020/07/18
 */
public class PException  extends ParseException{
    public PException(){
        System.out.println("协议异常");
    }

    public static void main(String[] args) throws java.text.ParseException {
       

    }
    public static void tweakPackageUtil (Class<?> packageUtilClass, String vendor, String version, String specTitle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
    {
        Field vendorField = packageUtilClass.getDeclaredField("vendor");
        vendorField.setAccessible(true);
        vendorField.set(null, vendor);

        Field versionField = packageUtilClass.getDeclaredField("version");
        versionField.setAccessible(true);
        versionField.set(null, version);

        Field specTitleField = packageUtilClass.getDeclaredField("specTitle");
        specTitleField.setAccessible(true);
        specTitleField.set(null, specTitle);
    }
}
