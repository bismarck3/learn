/**
 * @projectName springbootTest
 * @package springboot.write.str
 * @className springboot.write.str.IsAnagram
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * IsAnagram
 *
 * @description 有效的字母异位词(字母相同，位置不同)
 * @author wangjing
 * @date 2021/4/11 13:19
 * @version v1.0.0
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        for (char sChar : sChars) {
            if (map.containsKey(sChar)) {
                map.computeIfPresent(sChar, (key, value) -> ++value);
            } else {
                map.put(sChar, 1);
            }
        }
        char[] tChars = t.toCharArray();
        for (char tChar : tChars) {
            if (map.containsKey(tChar)) {
                Integer count = map.get(tChar);
                if (count -1 == 0) {
                    map.remove(tChar);
                } else {
                    map.computeIfPresent(tChar, (key, value) -> --value);
                }
            }
        }
        return map.size() == 0;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(tChars);
        return Arrays.equals(chars, tChars);
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("anagram", "nagaram"));
    }
}
