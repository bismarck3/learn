/**
 * @projectName springbootTest
 * @package springboot.learn.example
 * @className springboot.learn.example.PersonServiceImprove
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.example;

import java.util.ArrayList;
import java.util.List;

import springboot.learn.bean.Person;
import springboot.learn.supplier.PersonSupplier;

/**
 * PersonServiceImprove
 * @description PersonService     改进
 * @author wangj
 * @date 2018年9月4日
 * @version 
 */
public class PersonServiceImprove {

    List<Person> persons = PersonSupplier.getTestPersonDatas().get();
    
    /**
     * 
     * PersonServiceImprove
     * @description 查询策略
     * @param strategy
     * @return
     * @author wangj
     * @date 2018年9月4日 
     * @version 
     */
    public List<Person> find(Strategy strategy){
        List<Person> people = new ArrayList<>();
        for (Person person : persons) {
            if(strategy.matches(person)){
                people.add(person);
            }
        }
        return people;
    }
    
    /**
     * 
     * PersonServiceImprove
     * @description 根据名称筛选
     * @param name
     * @return
     * @author wangj
     * @date 2018年9月4日 
     * @version 
     */
    public List<Person> findByName(String name){
        return find(new Strategy(){

            @Override
            public boolean matches(Person person) {
                return name.equals(person.getName());
            }
            
        });
    }
    
    /**
     * 
     * PersonServiceImprove
     * @description 根据学校筛选
     * @param school
     * @return
     * @author wangj
     * @date 2018年9月4日 
     * @version 
     */
    public List<Person> findBySchool(String school){
        return find(new Strategy(){

            @Override
            public boolean matches(Person person) {
                return school.equals(person.getSchool());
            }
            
        });
    }
    
    /**
     * 
     * PersonServiceImprove
     * @description 根据诞生日筛选
     * @param birth
     * @return
     * @author wangj
     * @date 2018年9月4日 下午5:11:29
     * @version 
     */
    public List<Person> findByBirth(String birth){
        return find(p->birth.equals(p.getBirth()));
    }
}
