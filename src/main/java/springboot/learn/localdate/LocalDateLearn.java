package springboot.learn.localdate;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

public class LocalDateLearn {

    @Ignore
    @Test
    public void test() throws ClassNotFoundException {
        Class<?> c = Class.forName(LocalDate.class.getName());
        for (Method method : c.getMethods()) {
            System.out.print(method.getName()+"\t"+method.getParameterTypes());
        }
    }
    
    
    @Ignore
    @Test
    public void localDateTest() {
        LocalDate date = LocalDate.now();
        LocalDate date2 = LocalDate.of(2018, 11, 13);
        LocalDate date3 = LocalDate.parse("2018-11-13");
        LocalDate date4 = LocalDate.parse("2018-11-13");
        LocalDate minusDate = date4.minusMonths(1);
        
        String format = DateTimeFormatter.ofPattern("yyyy年MM月dd日").format(date4);
        System.out.println(format);
    }
    
    
//    @Ignore
    @Test
    public void localDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.withHour(0).withMinute(0).withSecond(0);
        System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        LocalDate localDate = localDateTime.toLocalDate();
    }
    
    @Ignore
    @Test
    public void localTime() {
//        LocalTime.of(hour, minute)
        LocalTime localTime2 = LocalTime.parse("11:00");
        System.out.println( DateTimeFormatter.ofPattern("hh时mm分").format(localTime2));
        System.out.println(localTime2);
        LocalDateTime localDateTime =  localTime2.withHour(11).atDate(LocalDate.now());
        System.out.println(localDateTime);
    }
    
}
