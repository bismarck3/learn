/**
 * @projectName springbootTest
 * @package springboot.basic.reflect
 * @className springboot.basic.reflect.EqualsToHashCode
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.reflect;

import springboot.learn.strategy.Main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * EqualsToHashCode
 *
 * @description hashCode测试
 * @author wangjing
 * @date 2019/7/30 19:19
 * @version v1.0.0
 */
class User{

    private String name;

    public User(){

    }

    public User(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        System.out.println("invoke equals");
        return false;
    }

    @Override
    public int hashCode(){
        System.out.println("invoke hashCode");
        return name.hashCode();
    }
}


public class EqualsToHashCode {

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        map.put(new User("1"), new Object());
        map.put(new User("2"), new Object());


        Map<User, Object> map2 = new LinkedHashMap<>();
        map2.put(new User("1"), new Object());
        map2.put(new User("2"), new Object());
        map2.put(new User("3"), new Object());
        map2.get(new User("1"));
        System.out.println(map2);
    }
}
