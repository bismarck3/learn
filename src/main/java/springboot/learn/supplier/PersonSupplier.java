/**
 * @projectName springbootTest
 * @package springboot.learn.supplier
 * @className springboot.learn.supplier.PersonSupplier
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;


import springboot.learn.bean.Person;

/**
 * PersonSupplier
 * 
 * @description Person supplier
 * @author wangj
 * @date 2018年9月4日 下午4:25:02
 * @version
 */
public class PersonSupplier {

    /**
     * 
     * PersonSupplier
     * @description 测试用personList数据
     * @return
     * @author wangj
     * @date 2018年9月4日 下午4:29:24
     * @version 
     */
    public static Supplier<List<Person>> getTestPersonDatas() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            Person person = new Person();
            person.setId(String.valueOf(UUID.randomUUID()));
            person.setAddress("街道" + (char)('A' + i));
            person.setAge(22 + i);
            person.setBirth("199" + (6 + i) + "-4-23");
            person.setName("Person" + (char)('A' + i));
            person.setSchool("学校" + (char)('A' + i));
            persons.add(person);
        }
        Supplier<List<Person>> supplier = () -> {
            return persons;
        };
        return supplier;
    }
    
}
