/**
 * @projectName springbootTest
 * @package springboot.basic.reflect
 * @className springboot.basic.reflect.ClassVarTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.reflect;

import java.util.Random;

/**
 * ClassVarTest
 *
 * @description 类字面量测试
 * @author wangjing
 * @date 2019/7/30 11:00
 * @version v1.0.0
 */
class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassVarTest.rand.nextInt(1000);
    static{
        System.out.println("Initializing Initable");
    }
}

class Initable2{
    static int staticNonFinal = 147;
    static{
        System.out.println("Initializing Initable2");
    }
}

class Initable3{
    static int staticNonFinal = 247;
    static{
        System.out.println("Initializing Initable3");
    }
}


public class ClassVarTest {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("springboot.basic.reflect.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
