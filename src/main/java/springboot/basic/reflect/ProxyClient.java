package springboot.basic.reflect;

import springboot.basic.reflect.annotation.UserAnnotation;

import java.lang.reflect.Field;

public class ProxyClient {

    public static void main(String[] args) {
        User user = new User("w", 10);
        for (Field field : User.class.getDeclaredFields()) {
            UserAnnotation declaredAnnotation = field.getDeclaredAnnotation(UserAnnotation.class);
            if(declaredAnnotation != null){
                field.setAccessible(true);
                try {
                    field.set(user, "");
                } catch (IllegalAccessException e) {
                    System.err.println("没有指定属性的Accessible");
                }
            }
        }
    }
}
