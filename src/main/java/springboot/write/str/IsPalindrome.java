/**
 * @projectName springbootTest
 * @package springboot.write.str
 * @className springboot.write.str.IsPalindrome
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.str;
/**
 * IsPalindrome
 *
 * @description 判断回文串
 * @author wangjing
 * @date 2021/4/11 14:52
 * @version v1.0.0
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int left = 0;
        for (int i = chars.length - 1; i >= left; ) {
            char leftChar = chars[left];
            char rightChar = chars[i];
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                i--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            i--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        String removeSpecialWord = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder reverse = new StringBuilder(removeSpecialWord).reverse();
        return reverse.toString().equals(removeSpecialWord);
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
