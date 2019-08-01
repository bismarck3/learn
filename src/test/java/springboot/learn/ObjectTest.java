package springboot.learn;

import springboot.learn.bean.User;

public class ObjectTest {

    public static void copy(User user) {
        User user2 = user;
        user2.setId("1");
        System.out.println(user.getId());
    }
    
    public static void main(String[] args) {
        User user = new User();
        user.setId("231");
        copy(user);
    }
}
