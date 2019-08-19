/**
 * @projectName springbootTest
 * @package springboot.basic.commons.lang
 * @className springboot.basic.commons.lang.StringUtilsTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.commons.lang;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.mockito.internal.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static springboot.basic.commons.lang.TimeUtilsApiTest.test;

/**
 * StringUtilsTest
 *
 * @description 字符串工具类测试
 * @author wangjing
 * @date 2019/8/5 16:31
 * @version v1.0.0
 */
public class StringUtilsTest {

    private static String words = "If you abbreviate something, especially a word or a piece of writing, you make it shorter.";

    static void print(Object obj){
        System.out.println(obj);
    }

    static void testAbbreviate(){
        print(StringUtils.abbreviate(words,20));
    }

    static void testCapitalize(){
        String capitalizeWord = StringUtils.capitalize("cat");
        print(capitalizeWord);
    }

    static void testSplit(){
        String[] defaultSplitWords = StringUtils.split(words);
        for(String s : defaultSplitWords){
            print(s);
        }
        boolean endsWith = StringUtils.endsWith(words, ".");
        print(endsWith);
    }

    static void testJoinAndSplit(){
        List<String> stringList = Arrays.asList("Person","teacher","student");
        String joinWords = StringUtils.join(stringList, ",");
        print(joinWords);
        for (String s : StringUtils.split(joinWords, ",")) {
            System.out.println(s);
        }
    }

    static void testCenter(){
        System.out.println(StringUtils.center("a", 3, "0"));
    }

    static void testChomp(){
        System.out.println(StringUtils.chomp("student", "ent"));
    }

    static void test(){
        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};
        String join = StringUtils.join(numbers, ",");
        for (String s : join.split(",")) {
            System.out.println(s);
        }
        String s = "    123sdsad   ";
        StringUtils.trim(s);
    }

    public static void main(String[] args) {
        test();
    }
}
