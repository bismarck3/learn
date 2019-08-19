package springboot.basic.reflect;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        userConstructor();
    }

    static void userConstructor() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        User user1 = new User("w");
        User user = new User("w", 20);
        for (Constructor<?> declaredConstructor : user.getClass().getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
            User o = (User)declaredConstructor.newInstance();
            user.getClass().newInstance();
        }
    }

    static void userMethod() throws InvocationTargetException, IllegalAccessException {
        User user = new User("w", 20);
        System.out.println(user);
        Class<User> userClass = User.class;
        for (Method declaredMethod : userClass.getDeclaredMethods()) {
            declaredMethod.setAccessible(true);
//            System.out.println(declaredMethod);
            if(declaredMethod.getName().equals("setAge")){
                declaredMethod.invoke(user, 1);
                System.out.println(user);
            }
        }
    }


    static void userFiled(){
        User user = new User("w", 20);
        Class<? extends User> userClass = user.getClass();
        for (Field declaredField : userClass.getDeclaredFields()) {
            System.out.println(declaredField);
            try {
                declaredField.setAccessible(true);
                declaredField.get(user);
                if(declaredField.getName().equals("address")){
                    declaredField.set(user, "thunisoft");
                }
                if(declaredField.getType().getName() == String.class.getName()){
                    declaredField.set(user,"q");
                }
            } catch (IllegalAccessException e) {
                System.err.println("错误错误");
            }
        }
    }
}
