package springboot.learn.reflect;

import java.lang.reflect.Field;

public class ReflectMain {

	public static void main(String[] args) throws ClassNotFoundException, Exception, Exception {
//		Class<?> c = Class.forName(TestClass.class.getName());
//		Object obj = c.newInstance();
//		Method method = c.getDeclaredMethod("getNameAndAge");
//		Field field = c.getDeclaredField("age");
//		//设置private变量允许访问
//		field.setAccessible(true);
//		field.set(obj, 21);
//		Field field2 = c.getDeclaredField("name");
//		
//		//设置private变量允许访问
//		field2.setAccessible(true);
//		field2.set(obj, "wangj");
//		String s = (String) method.invoke(obj);
//		System.out.println(s);
		
	    //反射改变final属性
		Class<?> c = ReflectClass.class;
		Object obj = c.newInstance();
		Field field = c.getDeclaredField("s");
		field.setAccessible(true);
		field.set(obj, "Now it has been changed.");
		System.out.println(field.get(obj));
	}

}
