package springboot.basic;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Student {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Student student = new Student();
        student.setName("w");
//        System.out.println(PropertyUtils.getProperty(student, "name"));
//        PropertyUtils.setProperty(student, "name", "xxxxxxx");
//        System.out.println(student);

        Method getName = Student.class.getDeclaredMethod("getName");
        System.out.println(getName.invoke(student));
        Method setName = Student.class.getDeclaredMethod("setName", String.class);
        setName.invoke(student, "i");
        System.out.println(student);


//        PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(Student.class, "name");
//        System.out.println(propertyDescriptor.getReadMethod().invoke(student));
//        propertyDescriptor.getWriteMethod().invoke(student, "x");
//        System.out.println(student);
    }
}


