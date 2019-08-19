/**
 * @projectName springbootTest
 * @package springboot.basic.commons.lang
 * @className springboot.basic.commons.lang.WordsUtilsTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.commons.lang;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.WordUtils;

/**
 * WordsUtilsTest
 *
 * @description 单词工具类
 * @author wangjing
 * @date 2019/8/5 15:59
 * @version v1.0.0
 */
public class WordsUtilsTest {

    private static String words = "If you abbreviate something, especially a word or a piece of writing, you make it shorter.";

    static void print(Object obj){
        System.out.println(obj);
    }

    /**
     * WordsUtilsTest
     *  首字母大写
     **/
    static void testCapitalize(){
        print(WordUtils.capitalize(words));
    }


    public static void main(String[] args) {
        testCapitalize();
    }
}
