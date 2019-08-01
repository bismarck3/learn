package springboot.learn.bean;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * 
 * Person
 * 
 * @description 实体人员
 * @author wangj
 * @date 2018年4月27日 下午7:35:32
 * @version
 */
@Entity
public class Person {

    /**
     * 人员编号
     */

    @Id
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 学校
     */
    private String school;

    /**
     * 家庭地址
     */
    private String address;

    private Date birthday;
    

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 生日(yyyy-MM-dd)
     */
    private String birth;

    public String getId() {
        return id;
    }

    public void setId(String uuid) {
        this.id = uuid;
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
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Person() {
        super();
    }

    public Person(String id, String name, Integer age, String school, String address, String birth) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.school = school;
        this.address = address;
        this.birth = birth;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // 如果相等,则返回true
            return true;
        }
        if (obj == null) { // 如果指定对象为空
            return false;
        }
        if (!(obj instanceof Person)) { // 如果o不是Person的实例
            return false;
        }
        Person p = (Person) obj;
        if (this.name.equals(p.getName()) && this.age == p.getAge() && this.address.equals(p.getAddress())
            && this.birth.equals(p.getBirth()) && this.school.equals(p.getSchool())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", school=" + school + ", address=" + address
            + ", birthday=" + birthday + ", birth=" + birth + "]";
    }

    
}
