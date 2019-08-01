package springboot.learn.proxy;

import java.lang.reflect.Proxy;


/**
 * 动态代理
 * 特点：不需要实现接口
 * 缺点：被代理对象需要实现接口
 * @author wangjing-1
 *
 */
public class DynamicProxy {

    /**
     * handler表示具体代理操作
     * @author wangjing-1
     *
     */
    public static void main(String[] args) {
        IUserDao dao = new UserDao();
        IUserDao proxy = (IUserDao)Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new ExampleInvocationHandler(dao));
        proxy.save();
    }
}
