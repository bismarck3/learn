package springboot.junit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import springboot.junit.dao.PersonDao;
import springboot.junit.dao.PersonRepository;
import springboot.learn.bean.Person;

/**
 * 
 * PersonService
 * 
 * @description 人员信息服务类
 * @author wangj
 * @date 2018年4月27日 下午7:39:04
 * @version
 */
@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonRepository personRepository;

    /**
     * 身份证前缀
     */
    private static final String PREFIX = "513123";

    /**
     * 身份证后缀
     */
    private static final String SUFFIX = "0012";

    /**
     * 
     * PersonService
     * 
     * @description 获得人员身份证信息
     * @param person
     * @return
     * @author wangj
     * @date 2018年4月27日 下午7:42:37
     * @version
     */
    public String getPersonId(Person person) {
        return PREFIX + person.getBirth().replace("-", "") + SUFFIX;
    }

    /**
     * 
     * PersonService
     * 
     * @description 获取全部人员
     * @param size
     * @return
     * @author wangj
     * @date 2018年4月28日 下午1:38:37
     * @version
     */
    public List<Person> getPersonList(int size) {
        return personDao.getPersonList(size);
    }

    public Person getPersonFromDatabase(String id) {
        return personDao.getPersonFromDatabase(id);
    }

    public Person getPersonUseJpa(String id) {
        return personRepository.findById(id).get();
    }

    public Person getPersonByQuerySql(String name, String address) {
        return personRepository.getPersonByQuerySql(name, address);
    }

    public Person findPersonByName(String name) {
        return personRepository.findPersonByName(name);
    }

    public List<Person> findAllByName(String name, Pageable pageable) {
        return personRepository.findAllByName(name, pageable);
    }
}
