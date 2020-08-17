/**
 * @projectName learn
 * @package springboot.learn
 * @className springboot.learn.StringClassTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn;

public class StringClassTest {

    public static void main(String[] args) {
        String s1 = new String("s1");
        String s11 = new String("s1");

        String intern = s1.intern();
        System.out.println(s1 == intern);

        String s2 = new String("s") + new String("s");
        String intern1 = s2.intern();
        System.out.println(s2 == intern1);

    }
}
