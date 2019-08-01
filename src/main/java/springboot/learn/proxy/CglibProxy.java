package springboot.learn.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


/**
 * Cglib代理，用于被代理对象没有实现任何接口,实现MethodInterceptor
 * @author wangjing-1
 *
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;
    
    public CglibProxy(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object intercept(Object prxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("--proxy start.--");
        Object returnValue = method.invoke(target, args);
        System.out.println("--proxy end.--");
        return returnValue;
    }

    /**
     * Cglib特殊处理
     * @return
     */
    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this/*,NoOp.INSTANCE*/);
//        //设置过滤器
//        enhancer.setCallbackFilter(new CallbackFilter() {
//            
//            @Override
//            public int accept(Method arg0) {
//                if("query".equalsIgnoreCase(arg0.getName())){
//                    return 0;
//                }
//                else{
//                    return 1;
//                }
//            }
//        });
        return enhancer.create();
    }
    
    public static void main(String[] args) {
        IUserDao dao = new UserDao();
        IUserDao proxy = (IUserDao)new CglibProxy(dao).getProxyInstance();
        proxy.save();
    }
}
