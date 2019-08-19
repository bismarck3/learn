/**
 * @projectName springbootTest
 * @package springboot.basic.commons.lang
 * @className springboot.basic.commons.lang.ClassApitTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.commons.lang;

import org.apache.commons.lang.reflect.ConstructorUtils;
import org.apache.commons.lang.reflect.FieldUtils;
import org.apache.commons.lang.reflect.MethodUtils;
import springboot.basic.reflect.entity.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassApitTest
 *
 * @description commons-lang测试
 * @author wangjing
 * @date 2019/8/2 11:35
 * @version v1.0.0
 */
public class ClassApitTest {

    private static  User user = new User("123",12);

    static void print(Object obj){
        System.out.println(obj);
    }

    static void testGetUserConstructor()
        throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = ConstructorUtils.getAccessibleConstructor(User.class, String.class);
        Object user = constructor.newInstance("w");
        System.out.println(user);
    }
    
    
    static void testConstructorUtils()
        throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        // getAccessibleConstructor
        Constructor constructor = ConstructorUtils.getAccessibleConstructor(User.class, new Class[]{String.class, Integer.class});
        User instance = (User)constructor.newInstance("123", 12);
        print(instance);
        // invokeConstructor
        User user = (User)ConstructorUtils.invokeConstructor(User.class, new Object[] {"123", 23});
        print(user);
    }

    static void testMethodUtils() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User("123",12);
        System.out.println(user);
        Method setName = MethodUtils.getAccessibleMethod(User.class, "setName", String.class);
        setName.invoke(user,"wang");
        print(user);

        MethodUtils.invokeMethod(user, "setName", "xxx");
        print(user);
    }

    static void testFieldUtils(){
        // getField 与 getDeclaredField，
        // getFile:获取public的，包括从父类继承来的字段
        // getDeclaredField可以获取本类所有的字段，包括private的，但是不能获取继承来的字段，想要访问只能setAccessible(true)
        Field name = FieldUtils.getDeclaredField(User.class, "name", true);
        print(name);

        Field phone = FieldUtils.getDeclaredField(User.class, "phone");
        print(phone);
        Field phone2 = FieldUtils.getField(User.class, "phone");
        print(phone2);

        //--------------------

    }

    public static void main(String[] args)
        throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        testConstructorUtils();
    }


}
