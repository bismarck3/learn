package springboot.learn.aop;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import springboot.learn.annotation.QueryAnnotation;
import springboot.learn.bean.Person;

@Component
public class AopService {
    
    @Autowired  //①  注入上下文  
    private ApplicationContext context;  
      
    private AopService proxySelf; //②  表示代理对象，不是目标对象  
    @PostConstruct  //③ 初始化方法  
    private void setSelf() {  
        //从上下文获取代理对象（如果通过proxtSelf=this是不对的，this是目标对象）  
        //此种方法不适合于prototype Bean，因为每次getBean返回一个新的Bean  
        proxySelf = context.getBean(AopService.class);   
    } 

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    public String GET_PERSON = "SELECT * FROM person WHERE name = :name";
    
	private String s ="AOPClass";
	
	public String getString1() {
		s = "string1";
		return this.s;
	}
	
	public String getString2() {
		s = "string2";
		return this.s;
	}
	
	public String String3() {
		s = "string3";
		return this.s;
	}
	
	@QueryAnnotation(name = "age")
	public List<Person> getPersons(String sql, String name){
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("name", name);
	    return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(Person.class));
	}
	
	public List<Person> getPersonsByName(String name){
	    
	    return proxySelf.getPersons(GET_PERSON, name);
	    
	}
	
	public Person translatePersonBirthday(){
	    Person person = new Person();
	    person.setBirthday(new Date());
	    return person;
	}
}
