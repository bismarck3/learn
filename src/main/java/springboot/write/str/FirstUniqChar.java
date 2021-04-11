/**
 * @projectName springbootTest
 * @package springboot.write.str
 * @className springboot.write.str.FirstUniqChar
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * FirstUniqChar
 *
 * @description 字符串唯一字符
 * @author wangjing
 * @date 2021/4/11 12:02
 * @version v1.0.0
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.compute(chars[i], (key, value) -> -1);
            } else {
                map.put(chars[i], i);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                return entry.getValue();
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.indexOf(chars[i]) == s.lastIndexOf(chars[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar2("leetcode"));
    }
}
