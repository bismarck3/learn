/**
 * @projectName springbootTest
 * @package springboot.write.str
 * @className springboot.write.str.ReverseString
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.str;
/**
 * ReverseString
 *
 * @description 反转字符串
 * @author wangjing
 * @date 2021/4/10 19:51
 * @version v1.0.0
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while (start < end) {
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        new ReverseString().reverseString("hello".toCharArray());
    }

}
