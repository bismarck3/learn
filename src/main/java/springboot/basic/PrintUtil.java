/**
 * @projectName springbootTest
 * @package springboot.basic
 * @className springboot.basic.PrintUtil
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic;

import java.util.Arrays;
import java.util.List;

/**
 * PrintUtil
 *
 * @description 打印工具类
 * @author wangjing
 * @date 2019/8/2 17:58
 * @version v1.0.0
 */
public final class PrintUtil {

    private PrintUtil(){

    }

    public static void println(Object obj){
        System.out.println(obj);
    }

    public static void println(List<Object> objectList){
        objectList.forEach(obj -> println(obj));
    }

    public static void println(Object[] objects){
        Arrays.asList(objects).forEach(obj -> println(obj));
    }


    public static void print(Object obj){
        System.out.print(obj);
    }

    public static void print(List<Object> objectList){
        objectList.forEach(obj -> print(obj));
    }

    public static void print(Object[] objects){
        Arrays.asList(objects).forEach(obj -> print(obj));
    }
}
