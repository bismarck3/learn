/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.ExerciseDay5
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import springboot.basic.reflect.entity.Person;
import springboot.basic.reflect.entity.User;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ExerciseDay5
 *
 * @description 练习5
 * @author wangjing
 * @date 2019/8/12 13:44
 * @version v1.0.0
 */
public class ExerciseDay5 {

    public static Object getProperty(final Object bean, final String name){
        Object value = null;
        for (Field declaredField : bean.getClass().getDeclaredFields()) {
            if(Objects.equals(declaredField.getName(),name)){
                declaredField.setAccessible(true);
                try {
                    value = declaredField.get(bean);
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    public static boolean hasProperty(final Object bean, final String fieldName){
        for (Field declaredField : bean.getClass().getDeclaredFields()) {
            if(Objects.equals(declaredField.getName(),fieldName)){
                return true;
            }
        }
        return false;
    }

    public static Map<String, Object> beanToMap(Object dest){
        Map<String, Object> map = new HashMap<>(16);
        try {
            Field[] destFields = dest.getClass().getDeclaredFields();
            for (Field des : destFields) {
                des.setAccessible(true);
                map.put(des.getName(), des.get(dest));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }

    public static void copyProperties(final Object dest, final Object orig) throws IllegalAccessException {
        for (Field destDeclaredField : dest.getClass().getDeclaredFields()) {
            for (Field origDeclaredField : orig.getClass().getDeclaredFields()) {
                if(Objects.equals(destDeclaredField.getType().getName(), origDeclaredField.getType().getName())&&
                    Objects.equals(destDeclaredField.getName(), origDeclaredField.getName())){
                    destDeclaredField.setAccessible(true);
                    origDeclaredField.setAccessible(true);
                    origDeclaredField.set(orig, destDeclaredField.get(dest));
                }
            }
        }
    }


    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("w", 10);
        Person person = new Person();
        copyProperties(user, person);
        System.out.println(person);
    }
}
