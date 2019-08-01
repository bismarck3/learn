package springboot.junit.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.junit.Test;

import springboot.learn.bean.Person;


public class ApacheConverterTest {


    @Test
    public void dateConvertTest() throws IllegalAccessException, InvocationTargetException {
        Person person = new Person(); 
        DateConverter dateConverter = new DateConverter();
        dateConverter.setPattern("yyyy-MM-dd");
        String stringDate = "1996-04-23";
        ConvertUtils.register(dateConverter, Date.class);
        BeanUtils.setProperty(person, "birthday", stringDate);
        System.out.println(person.getBirthday());
    }
}
