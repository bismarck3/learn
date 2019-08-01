package springboot.junit.dao;

import static org.hamcrest.CoreMatchers.startsWith;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.MyApplication;
import springboot.junit.dao.PersonDao;
import springboot.junit.matcher.MyMatcher;

/**
 * 
 * PersonDaoTest
 * 
 * @description personDao测试类
 * @author wangj
 * @date 2018年4月28日 下午1:12:08
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class PersonDaoTest {

    @Autowired
    private PersonDao personDao;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    /**
     * 
     * PersonDaoTest
     * 
     * @description 测试allOf断言
     * @author wangj
     * @date 2018年4月28日 下午1:20:45
     * @version
     */
    @Test
    public void testGetPersonPrefixAndSufix() {
        Assert.assertThat("人员school以学校开头,并且以字母X结束", personDao.getPerson().getSchool(),
            Matchers.allOf(startsWith("学校"), Matchers.endsWith("X")));
    }

    /**
     * 
     * PersonDaoTest
     * 
     * @description 测试anyOf断言
     * @author wangj
     * @date 2018年4月28日 下午1:20:30
     * @version
     */
    @Test
    public void testGetPersonPrefixOrSufix() {
        Assert.assertThat("人员school以学校开头,或者以字母X结束", personDao.getPerson().getSchool(),
            Matchers.anyOf(Matchers.startsWith("学校"), Matchers.endsWith("X")));
    }

    /**
     * 
     * PersonDaoTest
     * 
     * @description 测试自定义Matcher
     * @author wangj
     * @date 2018年4月28日 下午1:20:17
     * @version
     */
    @Test
    public void testPersonOfWang() {
        Assert.assertThat(personDao.getPerson("小马", "2018-01-01"), new MyMatcher());
    }
}
