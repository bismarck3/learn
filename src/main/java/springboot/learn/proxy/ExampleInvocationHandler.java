package springboot.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理，实现InvocationHandler
 * invocationHandler.invoke方法，proxy参数实例
 * @author wangjing-1
 *
 */
public class ExampleInvocationHandler implements InvocationHandler{

    private Object proxy;
    
    public ExampleInvocationHandler(Object proxy) {
        super();
        this.proxy = proxy;
    }

    /**
     * prxy:1.可以获得被代理对象的对象信息。2.可以返回代理对象，进行连续调用。
     * method:被代理方法。
     * args:被代理方法参数。
     *     ****直接使用prxy会死循环****
     */
    @Override
    public Object invoke(Object prxy, Method method, Object[] args) throws Throwable {
        System.out.println(prxy.getClass().getMethods());
        System.out.println("--proxy start.--");
        method.invoke(proxy, args);
        System.out.println("--proxy end.--");
        return null;
    }

}
