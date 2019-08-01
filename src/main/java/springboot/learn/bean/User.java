/**
 * @projectName springbootTest
 * @package springboot.bean
 * @className springboot.bean.User
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.bean;

/**
 * User
 * @description 
 * @author wangj
 * @date 2018年9月4日 下午12:39:23
 * @version 
 */
public class User {
    
    /** id **/
    private String id;
    
    /** 姓名 **/
    private String name;
    
    /** 年龄 **/
    private Integer age; 
    
    /** 地址 **/
    private Address address;

    /** 学校 **/
    private School school;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", school=" + school
            + "]";
    }
    
    
}
