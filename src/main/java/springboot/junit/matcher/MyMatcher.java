package springboot.junit.matcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import springboot.learn.bean.Person;

/**
 * 
 * MyMatcher
 * 
 * @description 自定义assertThat-mather-person.name=小王
 * @author wangj
 * @date 2018年4月28日 下午1:11:05
 * @version
 */
public class MyMatcher extends BaseMatcher<Person> {

    @Override
    public boolean matches(Object item) {
        if (item == null) {
            return false;
        }
        Person person = (Person)item;
        return "小王".equals(person.getName());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("小王用户.");
    }

}
