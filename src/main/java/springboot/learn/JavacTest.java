/**
 * @projectName learn
 * @package springboot.learn
 * @className springboot.learn.JavacTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn;


/**
 * JavacTest
 *
 * @description javac测试
 * @author wangjing
 * @date 2020/8/26 14:20
 * @version v1.0.0
 */
public class JavacTest {

//    static void test(){
//        String str3 = new String("2");
//        String intern = str3.intern();
//        String str4 = "22";
//        System.out.println(str3 == intern);
//        System.out.println(str3 == str4);
//        System.out.println(intern == str4);
//    }

    static void test2(){
        String str3 = new String("2") + new String("2");
        String intern = str3.intern();
        String str4 = "22";
        System.out.println(str3 == intern);
        System.out.println(intern == str4);
        System.out.println(str3 == str4);
    }

    public static void main(String[] args) {
//        test();
        System.out.println("-------");
        test2();
    }
}
