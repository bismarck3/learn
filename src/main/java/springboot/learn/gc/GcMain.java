/**
 * @projectName learn
 * @package springboot.learn.gc
 * @className springboot.learn.gc.Main
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.gc;
/**
 * Main
 *
 * @description 主方法
 * @author wangjing
 * @date 2021/3/18 11:18
 * @version v1.0.0
 */
public class GcMain {

    public static void main(String[] args) {
        byte[] b1 = new byte[1024];
        byte[] b2 = new byte[1024];
        byte[] b3 = new byte[1024];
        b2 = null;
        b2 = new byte[1024];
    }
}
