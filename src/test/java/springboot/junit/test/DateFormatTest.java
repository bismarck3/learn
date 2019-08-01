package springboot.junit.test;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

public class DateFormatTest {

    @Test
    public void test() throws ParseException {
        String stringDate = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        String [] patterns = {"yyyy-MM-dd"};
        Date date = DateUtils.parseDate(stringDate, patterns);
        System.out.println(date);
    }
}
