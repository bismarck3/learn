/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.BitMap
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write;

import java.util.BitSet;

/**
 * BitMap
 *
 * @description 位图
 * @author wangjing
 * @date 2021/4/10 18:23
 * @version v1.0.0
 */
public class BitMap {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(17225839);
        bitSet.set(17225838);
        bitSet.set(17225837);
        bitSet.set(17225836);
        bitSet.set(17225835);
        for (int i = bitSet.nextSetBit(0); i >= 0 ; i = bitSet.nextSetBit(i+1)) {
            System.out.println(i);
        }

    }
}
