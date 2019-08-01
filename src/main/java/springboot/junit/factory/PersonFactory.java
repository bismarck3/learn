package springboot.junit.factory;

import java.util.Random;
import java.util.function.Supplier;

import springboot.learn.bean.Person;

/**
 * 
 * PersonFactory
 * 
 * @description 人员构造类
 * @author wangj
 * @date 2018年4月28日 上午11:24:31
 * @version
 */
public class PersonFactory {

    public static Supplier<Person> getPerson() {
        Supplier<Person> personSuppl = ()->{
            Person person = new Person();
            person.setAge(18);
            person.setId(String.valueOf(new Random().nextInt()));
            person.setAddress("北京华宇信息技术有限公司");
            person.setSchool("学校" + (char)('A' + new Random().nextInt(26)));
            return person;
        };
        
        return personSuppl;
    }

}
