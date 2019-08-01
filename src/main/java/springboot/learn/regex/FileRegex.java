/**
 * @projectName springbootTest
 * @package springboot.learn.regex
 * @className springboot.learn.regex.FileRegex
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.regex;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FileRegex
 * @description 中文识别regex
 * @author wangj
 * @date 2018年9月4日 下午4:11:57
 * @version 
 */
public class FileRegex {

    private static Logger logger = LoggerFactory.getLogger(FileRegex.class);


    @Test
    public void test() {
//        File file = new File("C:\\Users\\wangj\\Desktop\\target.txt");
        try {
            List<String> itrList = new ArrayList<String>();

            File mapFile = new File("C:\\Users\\wangj\\Desktop\\target.txt");
                String mapString = FileUtils.readFileToString(mapFile, "utf-8");
            // Pattern pattern = Pattern.compile("(-){2}(\\s){0,2}[\\x{4e00}-\\x{9fa5}]+");
            Pattern pattern = Pattern.compile("[,][B-J][$]{0,1}[0-9]");
            Matcher matcher = pattern.matcher(mapString);
                while (matcher.find()) {
                    String s = matcher.group();
                    itrList.add(s.trim());
                }

            itrList.stream().forEach(
                x -> System.out.println(x));

        } catch (IOException e) {
            logger.error("Bug in CsvLearn", e);
        }
    }
}
