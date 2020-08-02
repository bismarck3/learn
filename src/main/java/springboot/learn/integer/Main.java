/**
 * @projectName springbootTest
 * @package springboot.learn.integer
 * @className springboot.learn.integer.Maijn
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.integer;
/**
 * Maijn
 *
 * @description integer常量测试
 * @author wangjing
 * @date 2020/7/31 11:42
 * @version v1.0.0
 */
public class Main {

    private static void five() {
//        Integer i = new Integer(555);
//        Integer j = new Integer(555);

//        Integer i = 127;
//        Integer j = new Integer(127);

//        Integer i = -128;
//        Integer j = -128;

        Integer i = new Integer(5);
        Integer j = new Integer(5);

        if(i == j){
            System.out.println("i==j is equal");
        }else {
            System.out.println("i==j is not equal");
        }
    }

    public static void main(String[] args){
        five();

    }

}
