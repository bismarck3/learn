/**
 * @projectName springbootTest
 * @package springboot.basic.reflect
 * @className springboot.basic.reflect.EqualsToHashCode
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.reflect;

import springboot.basic.reflect.annotation.UserAnnotation;
import springboot.learn.strategy.Main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * EqualsToHashCode
 *
 * @description hashCode测试
 * @author wangjing
 * @date 2019/7/30 19:19
 * @version v1.0.0
 */
class User implements IUser{

    private String name;

    private Integer age;

    public User(){

    }

    public User(String name){
        this.name = name;
    }

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void print(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("执行equals");
        return this.name.equals(((User)o).getName());
    }

    @Override
    public int hashCode() {
        System.out.println("执行hashCode");
        return name.hashCode();
    }
}


public class EqualsToHashCode {

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        map.put(new User("1"), new Object());
        map.put(new User("1"), new Object());


//        Map<User, Object> map2 = new HashMap<>();
//        map2.put(new User("1"), new Object());
//        map2.put(new User("2"), new Object());
//        map2.put(new User("3"), new Object());
//        map2.get(new User("1"));
//        System.out.println(map2);
    }
}
