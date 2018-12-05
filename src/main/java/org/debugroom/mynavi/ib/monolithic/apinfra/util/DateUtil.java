package org.debugroom.mynavi.ib.monolithic.apinfra.util;

import java.time.ZonedDateTime;

public interface DateUtil {

    public static String getCurrentDay(){
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        return new StringBuilder()
                .append(currentDateTime.getYear())
                .append(currentDateTime.getMonth())
                .append(currentDateTime.getDayOfMonth())
                .toString();
    }

}
