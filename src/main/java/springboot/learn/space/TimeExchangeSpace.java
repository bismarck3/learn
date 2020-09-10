/**
 * @projectName learn
 * @package springboot.learn.space
 * @className springboot.learn.space.TimeExchangeSpace
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.space;
/**
 * TimeExchangeSpace
 *
 * @description 时间换空间
 * @author wangjing
 * @date 2020/8/26 20:49
 * @version v1.0.0
 */
public class TimeExchangeSpace {

    public static void main(String[] args) {
        UnsignedByte unsignedByte = new UnsignedByte();
        byte b = -0b1000;
        System.out.println(unsignedByte.getValue(b));
    }
}

class UnsignedByte{

    public short getValue(byte i){
        return (short) (i & 0xff);
    }

    public byte toUnsignedByte(short i){
        return (byte) (i & 0xff);
    }
}
