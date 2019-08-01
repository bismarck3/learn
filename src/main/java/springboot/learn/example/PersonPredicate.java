package springboot.learn.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

import springboot.learn.bean.Person;
import springboot.learn.supplier.PersonSupplier;

/**
 * 
 * PersonPredicate
 * 
 * @description 利用断言函数实现
 * @author wangj
 * @date 2018年9月4日
 * @version
 */
public class PersonPredicate {

    // 假设这个list是通过已有接口返回的所有Person集合
    private static List<Person> persons = PersonSupplier.getTestPersonDatas().get();

    public List<Person> findByName(String name) {
        return find(p -> name.equals(p.getName()));
    }

    public List<Person> findBySchool(String school) {
        return find(p -> school.equals(p.getSchool()));
    }

    public List<Person> findByAge(int age) {
        return find(p -> age == p.getAge());
    }

    public List<Person> findByAgeRange(int startAge, int endAge) {
        return find(p -> startAge <= p.getAge() && endAge >= p.getAge());
    }

    private List<Person> find(Predicate<Person> predicate) {
        List<Person> people = new ArrayList<>();
        for (Person person : persons) {
            if (predicate.test(person)) {
                people.add(person);
            }
        }
        return people;
    }

    // private List<Person> find(Predicate<Person> predicate){
    // return persons.stream().filter(p -> predicate.test(p)).collect(Collectors.toList());
    // }

    @Test
    public void testMain() {
        PersonPredicate personPredicate = new PersonPredicate();
        System.out.println(personPredicate.findByAge(22));
    }

    @Ignore
    @Test
    public void testUseStream() {
        Integer startAge = 22;
        Integer endAge = 30;
        List<Person> people = persons.stream()
                                     .filter(p -> startAge <= p.getAge() && endAge >= p.getAge())
                                     .collect(Collectors.toList());
        System.out.println(people);
    }
}
