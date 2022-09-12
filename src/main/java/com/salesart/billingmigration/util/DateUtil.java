package com.salesart.billingmigration.util;

import com.salesart.billingmigration.exception.DateFormatException;
import lombok.experimental.UtilityClass;
import org.apache.maven.surefire.shade.booter.org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class DateUtil {
    public Date convert(String source) throws DateFormatException {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
        }
        catch (ParseException parseException) {
            throw new DateFormatException("Entered Date Format Wrong, Correct format is (yyyy-MM-dd HH:mm:ss)");
        }
    }
}
