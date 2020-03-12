package org.shigm.exception;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyConverter implements Converter<String, Date> {
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String s) {
        if (null!=s && !"".equals(s)) {
            try {
                return  format.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
