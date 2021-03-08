/**
 * @projectName learn
 * @package springboot.learn.cache
 * @className springboot.learn.cache.CpuCacheMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.cache;

import java.text.DecimalFormat;

/**
 * CpuCacheMain
 *
 * @description cpu缓存
 * @author wangjing
 * @date 2020/11/23 17:40
 * @version v1.0.0
 */
public class CpuCacheMain {

    public static void main(String[] args) {
        long marked;
        for (int arraySize = 512; arraySize <= 128 * 1024 * 1024; arraySize <<= 1) {
            // 10*2^26
            int steps = 640 * 1024 * 1024;
            int lengthMod = arraySize - 1;
            char[] arr = new char[arraySize];

            marked = System.currentTimeMillis();
            for (int i = 0; i < steps; i += 64) {
                arr[i & lengthMod]++;
            }
            long used = (System.currentTimeMillis() - marked);
            System.out.println(formatSize(arraySize) + "\t" + used);
        }
    }

    /**
     * 把size单位转化为KB, MB, GB
     */
    public static String formatSize(long size) {
        String hrSize;

        double b = size;
        double k = size/1024.0;
        double m = ((size/1024.0)/1024.0);
        double g = (((size/1024.0)/1024.0)/1024.0);
        double t = ((((size/1024.0)/1024.0)/1024.0)/1024.0);

        DecimalFormat dec = new DecimalFormat("0");

        if ( t>1 ) {
            hrSize = dec.format(t).concat(" TB");
        } else if ( g>1 ) {
            hrSize = dec.format(g).concat(" GB");
        } else if ( m>1 ) {
            hrSize = dec.format(m).concat(" MB");
        } else if ( k>1 ) {
            hrSize = dec.format(k).concat(" KB");
        } else {
            hrSize = dec.format(b).concat(" Bytes");
        }
        return hrSize;
    }

}
