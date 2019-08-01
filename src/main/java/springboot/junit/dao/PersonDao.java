package springboot.junit.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import springboot.junit.factory.PersonFactory;
import springboot.learn.bean.Person;


@Repository
public class PersonDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * 
     * PersonDao
     * 
     * @description 模拟获取用户
     * @return
     * @author wangj
     * @date 2018年4月28日 下午1:39:14
     * @version
     */
    public Person getPerson() {
        // 模拟数据库取出数据
        Person person = PersonFactory.getPerson().get();
        person.setBirth("2000-01-01");
        person.setName("小王");
        return person;
    }

    /**
     * 
     * PersonDao
     * 
     * @description 获取用户
     * @param name
     * @param birth
     * @return
     * @author wangj
     * @date 2018年4月28日 下午1:39:01
     * @version
     */
    public Person getPerson(String name, String birth) {
        Person person = PersonFactory.getPerson().get();
        person.setName(name);
        person.setBirth(birth);
        return person;
    }

    /**
     * 
     * PersonDao
     * 
     * @description 模拟取出多个用户
     * @param size
     * @return
     * @author wangj
     * @date 2018年4月28日 下午1:38:48
     * @version
     */
    public List<Person> getPersonList(int size){
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            personList.add(getPerson("Person" + i, "200X-01-1".replace("X", String.valueOf(i))));
        }
        
        return personList;
    }

//    @Cacheable("persons")
    public Person getPersonFromDatabase(String id) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("id", id);              
        return namedParameterJdbcTemplate.query("select * from person where id =:id", map, new BeanPropertyRowMapper<Person>(Person.class)).get(0);
    }
}
