package springboot.basic.reflect;

public class ProxyUser implements IUser{

    private User user;

    public ProxyUser(User user){
        this.user = user;
    }

    @Override
    public void print() {
        // ...
        user.print();
        // ...
    }
}
