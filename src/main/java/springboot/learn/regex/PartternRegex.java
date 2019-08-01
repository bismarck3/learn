/**
 * @projectName springbootTest
 * @package springboot.learn.regex
 * @className springboot.learn.regex.PartternRegex
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * PartternRegex
 * @description 正则表达式测试
 * @author wangj
 * @date 2018年9月4日 下午4:13:32
 * @version 
 */
public class PartternRegex {

    private static final Pattern p = Pattern.compile("cat");
    
    @Test
    public void test(){
        Matcher m = p.matcher("one cat two cats in the yard");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "dog");
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
