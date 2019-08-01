package springboot.junit.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.MyApplication;
import springboot.learn.aop.AopService;
import springboot.learn.bean.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class AopTest {

	@Autowired
	private AopService aopService;
	
	@Test
	public void test1() {
	    Person person = new Person();
	    person.setName("123");
		System.out.println(aopService.getPersonsByName("123"));
	}
}
