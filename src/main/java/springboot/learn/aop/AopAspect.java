package springboot.learn.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import springboot.learn.annotation.QueryAnnotation;

@Aspect
@Component
public class AopAspect {

	@Pointcut("execution(* springboot.learn.aop..*.*(..))")
	public void test() {}
	
	@Pointcut("execution(* springboot.learn.aop.AopService.get*(..))")
	public void test2() {}
	
//	@Pointcut("bean(AopService)")
//	public void test3() {}
	
	@Pointcut("@annotation(springboot.learn.annotation.QueryAnnotation)")
	public void query() {}
	
//	@Before("test()")
//	public void before(JoinPoint joinPoint) {
//		joinPoint.getTarget();
//		joinPoint.getThis();
//		System.out.println("前置通知");
//	}

//	@After("test()")
//	public void after() {
//		System.out.println("后置通知");
//	}
	
//	@AfterReturning(value = "test2()", returning = "obj")
//	public void afterReturn(Object obj) {
//		System.out.println("后置通知"+obj);
//	}
	
//	@AfterThrowing(value = "test2()")
//	public void afterThrow() {
//		System.out.println("异常通知");
//	}
	
	@Around(value = "query() && @annotation(queryAnnotation)")
	public Object around(ProceedingJoinPoint joinPoint, QueryAnnotation queryAnnotation) throws Throwable {
		Object result;
		Object[] params = joinPoint.getArgs();
		String targetName = joinPoint.getTarget().getClass().getName();
		Class<?> c = Class.forName(targetName);
		c.newInstance();
		Method[] methods = c.getMethods();
		String thisName = joinPoint.getThis().getClass().getName();
		String param = queryAnnotation.name();
		String sql = (String)params[0];
		sql +=" AND "+param+"="+"123";
		
		result = joinPoint.proceed(new Object[] {sql, params[1]});
		
		
		
		return result;
	}
	
}
