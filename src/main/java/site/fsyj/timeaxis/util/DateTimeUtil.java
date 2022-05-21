package site.fsyj.timeaxis.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fsyj
 */
public class DateTimeUtil {

    public static String get16SysTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date date = new Date();
        String dateStr = sdf.format(date);

        return dateStr;

    }

    public static String get19SysTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        String dateStr = sdf.format(date);

        return dateStr;

    }

    public static String get10SysTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        String dateStr = sdf.format(date);

        return dateStr;

    }


}
