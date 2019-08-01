/**
 * @projectName springbootTest
 * @package springboot.basic.reflect
 * @className springboot.basic.reflect.JavaIntrospector
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.reflect;

import springboot.basic.reflect.entity.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * JavaIntrospector
 *
 * @description java内省
 * @author wangjing
 * @date 2019/7/30 14:51
 * @version v1.0.0
 */
public class JavaIntrospector {

    static void reflect() throws IllegalAccessException, NoSuchFieldException {
        User user = new User();
        Field f = user.getClass().getDeclaredField("name");
        f.setAccessible(true);
        f.set(user, "mld");
        String name = (String)f.get(user);
        System.out.println(name);
    }

    static void introspector() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        //操作单个属性
        PropertyDescriptor pd = new PropertyDescriptor("name", User.class);
        Method w = pd.getWriteMethod();
        w.invoke(user, "winclpt");
        Method r = pd.getReadMethod();
        String name = (String)r.invoke(user);
        System.out.println(name);
        //访问全部属性
        BeanInfo bi = Introspector.getBeanInfo(User.class);
        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
        for(PropertyDescriptor p : pds) {
            System.out.println(p);
        }
    }

    public static void main(String[] args)
        throws NoSuchFieldException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        reflect();
        introspector();
    }
}
