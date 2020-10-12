/**
 * @projectName learn
 * @package springboot.learn.number
 * @className springboot.learn.number.FloatMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.number;
/**
 * FloatMain
 *
 * @description 
 * @author wangjing
 * @date 2020/9/22 16:28
 * @version v1.0.0
 */
public class FloatMain {


    public static void main(String[] args) {
        doubleToLong();
    }

    private static void doubleToLong(){
        long i = Double.doubleToLongBits(3.141592);
        double v = Double.longBitsToDouble(i);
        System.out.println(i);
        System.out.println(v);
        System.out.println(1.0f / 0.0f);
        System.out.println(0.0d / 0.0);
    }

    private static void floatToInt() {
        int i = Float.floatToIntBits(3.141592f);
        float v = Float.intBitsToFloat(i);
        System.out.println(i);
        System.out.println(v);
        System.out.println(1.0f / 0.0f);
    }
}
