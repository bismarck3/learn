package springboot.learn.propertyutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import springboot.learn.bean.User;

public class PropertyUtilsTest {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        User user = new User();
        user.setAge(13);
        user.setId("2313213123123123");
        PropertyUtils.getSimpleProperty(user, "age");
        Map<String, Object> properyMap = new HashMap<>();
        properyMap.put("age", 123);
        properyMap.put("name", "wangj");
        BeanUtils.populate(user, properyMap);
        System.out.println(user);
    }
}
