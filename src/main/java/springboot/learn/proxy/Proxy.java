package springboot.learn.proxy;

/**
 * 静态代理
 * 被代理对象与代理对象一起实现相同的接口或继承相同父类，对目标对象进行扩展
 * 缺点：需要和被代理对象一起实现接口
 * @author wangjing-1
 *
 */
public class Proxy implements IUserDao{

    private IUserDao target;
    
    
    public Proxy(IUserDao target) {
        super();
        this.target = target;
    }

    @Override
    public void save() {
            System.out.println("-proxy:start-");
            target.save();
            System.out.println("-proxy:end-");
    }
    
    public static void main(String[] args) {
        IUserDao dao = new UserDao();
        IUserDao proxy = new Proxy(dao);
        proxy.save();
    }
    
}
