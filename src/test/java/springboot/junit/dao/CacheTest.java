package springboot.junit.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.MyApplication;
import springboot.learn.bean.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class CacheTest {

	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonDao personDao;
	
	@Test
	public void test(){
		Person person = personDao.getPersonFromDatabase("1");
		Person person2 = personDao.getPersonFromDatabase("1");
		Person person3 = personDao.getPersonFromDatabase("1");
	}
}
