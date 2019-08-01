package springboot.learn.proxy;

public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("---save---");
    }

}
