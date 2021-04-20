/**
 * @projectName springbootTest
 * @package springboot
 * @className springboot.write.str.Main
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.str;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main
 *
 * @description 字符串压缩
 * @author wangjing
 * @date 2021/4/16 20:11
 * @version v1.0.0
 */
public class StrZip {

    public String zipStr2(String str) {
        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int tag = 1;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (i+1 < chars.length && chars[i] != chars[i+1]) {
                }
                map.computeIfPresent(chars[i], (key, value) -> ++value);
            } else {
                map.put(chars[i], 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            result.append(entry.getKey());
            Integer value = entry.getValue();
            if (value > 1) {
                result.append(value);
            }
        }
        return result.toString();
    }


    public String zipStr(String str) {
        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i+1 < chars.length && chars[i+1] != chars[i]) {
                result.append(chars[i]);
                if (count > 1) {
                    result.append(count);
                }
                count = 1;
            } else if (i+1 < chars.length && chars[i+1] == chars[i]) {
                count++;
            }
        }
        // 最后一个相同字符
        result.append(chars[chars.length-1]);
        if (count > 1) {
            result.append(count);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.next();
        System.out.println(new StrZip().zipStr(inputStr));
    }
}
