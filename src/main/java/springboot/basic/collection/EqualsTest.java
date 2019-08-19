package springboot.basic.collection;

import springboot.basic.reflect.entity.User;

public class EqualsTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("w1");
        user.setAge(1);

        User user2 = new User();
        user2.setName("w1");
        user2.setAge(1);

        System.out.println((user == user2));
        System.out.println(user.equals(user2));
    }
}
