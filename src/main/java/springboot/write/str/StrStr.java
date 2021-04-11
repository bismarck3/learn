/**
 * @projectName springbootTest
 * @package springboot.write.str
 * @className springboot.write.str.StrStr
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.str;

import java.util.ArrayList;
import java.util.List;

/**
 * StrStr
 *
 * @description 实现str函数
 * @author wangjing
 * @date 2021/4/11 16:34
 * @version v1.0.0
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        char[] leftArray = haystack.toCharArray();
        char[] rightArray = needle.toCharArray();
        int leftLength = haystack.length();
        int rightLength = needle.length();
        if (rightLength == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] == rightArray[j]) {
                i++;
                j++;
            } else {
                i = i - j +1;
                j = 0;
            }
        }
        if (j == rightLength) {
            return i-j;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("mississippi",
            "issip"));
    }
}
