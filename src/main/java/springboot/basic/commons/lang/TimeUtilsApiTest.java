/**
 * @projectName springbootTest
 * @package springboot.basic.commons.lang
 * @className springboot.basic.commons.lang.TimeUtilsApiTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.commons.lang;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import springboot.basic.PrintUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * TimeUtilsApiTest
 *
 * @description 时间工具类
 * @author wangjing
 * @date 2019/8/5 13:58
 * @version v1.0.0
 */
public class TimeUtilsApiTest {

    private static final String SYSTEM_DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal =
        ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    static void print(Object object){
        System.out.println(object);
    }

    static String dateToStringByPattern(Date date){
        return simpleDateFormatThreadLocal.get().format(date);
    }

    static String dateFormat(Date date){
        return DateFormatUtils.format(date, SYSTEM_DEFAULT_DATE_TIME_PATTERN);
    }

    static void timeUtilsTest() throws ParseException {
        Date now = new Date();
        print(now);

        Date tomorrow = DateUtils.addDays(now,1);
        print(tomorrow);

        Date customizeDate =DateUtils.parseDate("2019-07-05",new String[]{"yyyy-MM-dd"});
        print(customizeDate);

    }

    static void timeUtilsIterator() throws ParseException {
        //Range_month_MonDay用法
        Date customizeDate =DateUtils.parseDate("2019-07-05",new String[]{"yyyy-MM-dd"});
        Iterator dateIterator = DateUtils.iterator(customizeDate, DateUtils.RANGE_MONTH_MONDAY);
        while(dateIterator.hasNext()) {
            Object nextCalendar = dateIterator.next();
            if (nextCalendar instanceof Calendar) {
                Calendar tempCalendar = (Calendar)nextCalendar;
                Date time = tempCalendar.getTime();
                String dateString = dateToStringByPattern(time);
                print(dateString);
            }
        }
    }

    static void timeCeilingTest(){
        Date now = new Date();
        //ceiling
        print(dateFormat(now));
        Date dateYear = DateUtils.ceiling(now, Calendar.YEAR);
        print(dateFormat(dateYear));
    }

    static void test(){
        Date now = new Date();
        print(dateFormat(now));
        Date truncateDate = DateUtils.truncate(now, Calendar.YEAR);
        print(dateFormat(truncateDate));
    }

    static void dateTest(){
        Date date = new Date();
        System.out.println(date);
        System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd"));
    }

    public static void main(String[] args) throws ParseException {
        dateTest();
    }
}
