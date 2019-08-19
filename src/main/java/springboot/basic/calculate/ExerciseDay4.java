/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.ExerciseDay4
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import java.lang.reflect.Field;

/**
 * ExerciseDay4
 *
 * @description 练习4
 * @author wangjing
 * @date 2019/8/8 15:21
 * @version v1.0.0
 */

class Student{

    private int age;

    private String name;

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "Student{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}


public class ExerciseDay4 {

    static void copyProperties(Object source, Object target) throws IllegalAccessException {
        for (Field targetDeclaredField : target.getClass().getDeclaredFields()) {
            for (Field sourceDeclaredField : source.getClass().getDeclaredFields()) {
                if(sourceDeclaredField.getName().equals(targetDeclaredField.getName())){
                    sourceDeclaredField.setAccessible(true);
                    Object sourceFieldValue = sourceDeclaredField.get(source);
                    targetDeclaredField.setAccessible(true);
                    targetDeclaredField.set(target, sourceFieldValue);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Student student = new Student();
        student.setName("w");
        student.setAge(10);
        Teacher teacher = new Teacher();
        copyProperties(student, teacher);
        System.out.println(teacher);
    }
}
