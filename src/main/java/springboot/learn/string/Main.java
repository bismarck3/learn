/**
 * @projectName springbootTest
 * @package springboot.learn.string
 * @className springboot.learn.string.Main
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.string;

import java.util.Arrays;

/**
 * Main
 *
 * @description 字符串测试
 * @author wangjing
 * @date 2020/8/3 16:13
 * @version v1.0.0
 */
public class Main {

    private static void one(){
        String str1 = new String("1");
        String intern1 = str1.intern();
        String str2 = "1";
        System.out.println(intern1 == str1);
        System.out.println(str1 == str2);

        String str3 = new String("2") + new String("2");
//        String intern = str3.intern();
        String str4 = "22";
//        System.out.println(str3 == intern);
        System.out.println(str3 == str4);
    }

    private static void tow(){
        String str1 = "aaa";
        String str2 = "bbb";
        String str3 = "aaabbb";
        String str4 = str1 + str2;
        String str5 = "aaa" + "bbb";
        System.out.println(str3 == str4);
        System.out.println(str3 == str4.intern());
        System.out.println(str3 == str5);
    }

    private static void three(){
        String t1 = new String("2");
        String t2 = "2";
        t1.intern();
        System.out.println(t1 == t2);

        String t3 = new String("2") + new String("2");
        String t4 = "22";
        t3.intern();
        System.out.println(t3 == t4);
    }

    private static void four(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a+b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }

    private static void five(){
        String s1 = new String("1");
        String s2 = s1.intern();
        String s3 = "1";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s3);
    }

    private static void six(){
        String[] s1 = {"a", "b"};
        String[] s2 = Arrays.copyOfRange(s1, 0, s1.length);
        System.out.println(s1 == s2);
    }

    public static void main(String[] args) {
        one();
    }
}
