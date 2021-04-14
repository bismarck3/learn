/**
 * @projectName springbootTest
 * @package springboot.write.str
 * @className springboot.write.str.LongestCommonPrefix
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.str;
/**
 * LongestCommonPrefix
 *
 * @description 最长公共前缀
 * @author wangjing
 * @date 2021/4/11 20:43
 * @version v1.0.0
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String s = strs[0];
        int n = s.length();
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(s.substring(0, n))) {
                n--;
            }
        }
        return s.substring(0, n);
    }
}
