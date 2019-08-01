/**
 * @projectName springbootTest
 * @package springboot.basic.reflect
 * @className springboot.basic.reflect.InnerClassTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * InnerClassTest
 *
 * @description 内部类测试
 * @author wangjing
 * @date 2019/7/30 10:31
 * @version v1.0.0
 */
public class InnerClassTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(InnerClassTest.class);

    class InnerParent{
        InnerParent(){}
        InnerParent(int i ){}
    }

    class InnerChild extends InnerParent{
        InnerChild(int i ){super(1);}
    }

    static void printSuperClassInfo(Class clazz) {
        Class supr = clazz.getSuperclass();
        Object obj = null;
        InnerClassTest innerClassTest = new InnerClassTest();
        try {
            Constructor[] declaredConstructors = supr.getDeclaredConstructors();
            int i = declaredConstructors[0].getModifiers();
            obj = declaredConstructors[0].newInstance(innerClassTest);
//            obj = supr.newInstance(innerClassTest);
            System.out.println(obj);
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("获取类实例失败:"+clazz.getName(), e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Class clazz = null;
        Class clazz2 = null;
        try {
            clazz = Class.forName("springboot.basic.reflect.InnerClassTest$InnerChild");
            printSuperClassInfo(clazz);
        } catch (ClassNotFoundException e) {
            LOGGER.error("类加载失败", e);
        }
    }
}
