/**
 * @projectName springbootTest
 * @package springboot.learn.example
 * @className springboot.learn.example.PersonService
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.example;

import java.util.ArrayList;
import java.util.List;

import springboot.learn.bean.Person;
import springboot.learn.supplier.PersonSupplier;

/**
 * PersonService
 * @description 
 * @author wangj
 * @date 2018年9月4日 
 * @version 
 */
public class PersonService {

    private List<Person> persons = PersonSupplier.getTestPersonDatas().get();
    
    /**
     * 
     * PersonService
     * @description 根据名字筛选people
     * @param name
     * @return
     * @author wangj
     * @date 2018年9月4日 
     * @version 
     */
    public List<Person> findByName(String name){
        List<Person> people = new ArrayList<>();
        for (Person person : persons) {
            if(name.equals(person.getName())){
                people.add(person);
            }
        }
        return people;
    }
    
    /**
     * 
     * PersonService
     * @description 根据学校筛选people
     * @param school
     * @return
     * @author wangj
     * @date 2018年9月4日
     * @version 
     */
    public List<Person> findBySchool(String school){
        List<Person> people = new ArrayList<>();
        for (Person person : persons) {
            if(school.equals(person.getSchool())){
                people.add(person);
            }
        }
        return people;
    }
}
