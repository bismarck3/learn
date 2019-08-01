/**
 * @projectName springbootTest
 * @package springboot.basic.reflect.entity
 * @className springboot.basic.reflect.entity.User
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.reflect.entity;
/**
 * User
 *
 * @description 用户
 * @author wangjing
 * @date 2019/7/30 14:51
 * @version v1.0.0
 */
public class User {

    private String name;

    private int age;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
