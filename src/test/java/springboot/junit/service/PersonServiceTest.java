package springboot.junit.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.MyApplication;
import springboot.junit.factory.PersonFactory;
import springboot.learn.bean.Person;

/**
 * 
 * PersonServiceTest
 * 
 * @description personService测试类
 * @author wangj
 * @date 2018年4月28日 下午1:12:26
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Ignore
    @Test
    public void testCondition() {
        Assert.assertThat(50, Matchers.lessThan(80));
    }
    
    /**
     * 
     * PersonServiceTest
     * 
     * @description 测试身份证拼接service
     * @author wangj
     * @date 2018年4月28日 下午1:20:56
     * @version
     */
    @Ignore
    @Test
    public void testGetPersonId() {
        Person person = new Person();
        person.setBirth("2000-01-01");
        Assert.assertEquals("513123200001010012", personService.getPersonId(person));
    }

    /**
     * 
     * PersonServiceTest
     * @description 测试List.hasItem
     * @author wangj
     * @date 2018年8月9日 下午5:39:06
     * @version 
     */
    @Ignore
    @Test
    public void testCollection() {
        Person person = PersonFactory.getPerson().get();
        person.setName("Person1");
        person.setBirth("2001-01-01");

        List<Person> personList = personService.getPersonList(10);

        personList.add(person);

        Assert.assertThat("是否包含姓名Person1,生日为2001-01-01年的人员", personList,
            Matchers.hasItem(person));
    }

    /**
     * 
     * PersonServiceTest
     * @description 测试map.hasEntry
     * @author wangj
     * @date 2018年8月9日 下午5:39:23
     * @version 
     */
    @Ignore
    @Test
    public void testMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        Person person1 = PersonFactory.getPerson().get();
        person1.setName("Person1");
        person1.setBirth("2001-01-01");

        Person person2 = PersonFactory.getPerson().get();
        person2.setName("Person2");
        person2.setBirth("2002-02-02");

        map.put("Person1", person1);
        map.put("Person2", person2);

        Assert.assertThat("是否包含姓名Person1,生日为2001-01-01年的人员", map, Matchers.hasEntry("Person1", person1));
    }

    /**
     * 
     * PersonServiceTest
     * @description 从数据库中获取用户
     * @author wangj
     * @date 2018年8月9日 下午5:39:44
     * @version 
     */
    @Ignore
    @Test
    public void testYml() {
        Assert.assertThat("id为1的用户是否是姓名为wangj的person", "wang",
            Matchers.equalTo(personService.getPersonFromDatabase("1").getName()));
    }

    /**
     * 
     * PersonServiceTest
     * @description JPA测试-手写JPQL
     * @author wangj
     * @date 2018年8月9日 下午5:40:14
     * @version 
     */
    @Ignore
    @Test
    public void testQuery() {
        Assert.assertEquals("1", personService.getPersonByQuerySql("wangj", "hy").getId());
    }

    /**
     * 
     * PersonServiceTest
     * @description JPA测试-自动生成findPersonByName
     * @author wangj
     * @date 2018年8月9日 下午5:40:27
     * @version 
     */
    @Ignore
    @Test
    public void testFindPersonByName() {
        Assert.assertEquals("wangj", personService.findPersonByName("wangj"));
    }

    /**
     * 
     * PersonServiceTest
     * @description 测试JPA自动生成findAllByName
     * @author wangj
     * @date 2018年8月9日 下午5:41:50
     * @version 
     */
    @Ignore
    @Test
    public void testFindAllByName() {
        Pageable pageable = PageRequest.of(0, 2);
        Person person = new Person("2", "wang", 22, "uestc", "yh", "1996");
        // List<Person> persons = personService.findAllByName("wang", pageable);
        Assert.assertThat(personService.findAllByName("wang", pageable), Matchers.hasItem(person));;
        // Boolean bool = persons.contains(person);
        // Assert.assertEquals(true, bool);
    }

    /**
     * 
     * PersonServiceTest
     * @description 测试List.hasItem
     * @author wangj
     * @date 2018年8月9日 下午5:42:26
     * @version 
     */
    @Ignore
    @Test
    public void testHasItem() {
        List<String> list = Arrays.asList("1", "2", "3");
        Assert.assertThat(list, Matchers.hasItem("3"));
    }
    
    @Test
    public void testSort() {
        List<Person> personList = personService.getPersonList(10);
        personList.sort(Comparator.comparing(Person::getId));
        personList.forEach(System.out::println);
    }
}
