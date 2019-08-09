/**
 * @projectName springbootTest
 * @package springboot.basic.commons.io
 * @className springboot.basic.commons.io.IoUtilsTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.commons.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.util.Chars;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * IoUtilsTest
 *
 * @description io工具类
 * @author wangjing
 * @date 2019/8/8 15:45
 * @version v1.0.0
 */
class FileNameUtilsTest{

    private static final String FILE_NAME = "测试读取文件.txt";

    private static final String FILE_WHOLE_DIRECTORY = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习";

    private static final String FILE_WHOLE = FILE_WHOLE_DIRECTORY+"\\"+FILE_NAME;


    /**
     * FileNameUtilsTest
     *
     * @description 获取文件的baseName,无后缀的名称
     * @author wangjing-1
     * @date 2019/8/8 16:37
     * @version v1.0.0
     **/
    static void testGetBaseName(){
        System.out.println(FilenameUtils.getBaseName(FILE_NAME));
    }

    /**
     * FileNameUtilsTest
     * 链接文件直接目录与文件全称
     **/
    static void testFileConcat(){
        System.out.println(FilenameUtils
            .concat(FilenameUtils.getBaseName(FILE_WHOLE_DIRECTORY), FILE_NAME));
    }

    /**
     * FileNameUtilsTest
     * 获取文件后缀
     **/
    static void testGetExtension(){
        System.out.println(FilenameUtils.getExtension(FILE_NAME));
    }

    static void testGetPrefix(){
        System.out.println(FilenameUtils.getPrefix(FILE_WHOLE_DIRECTORY));
    }

    static void testGetPathNoEndSeparator(){
        System.out.println(FilenameUtils.getPathNoEndSeparator(FILE_WHOLE_DIRECTORY));
    }

    static void testGetFullPath(){
        System.out.println(FilenameUtils.getFullPath(FILE_WHOLE_DIRECTORY));
    }

    static void testSeparatorsToSystem(){
        System.out.println(FilenameUtils.separatorsToWindows(FILE_WHOLE));
        System.out.println(FilenameUtils.separatorsToUnix(FILE_WHOLE));
        System.out.println(FilenameUtils.separatorsToSystem(FILE_WHOLE));
    }

}


class FileUtilsTest{

    private static final String FILE_NAME = "测试读取文件.txt";

    private static final String FILE_WHOLE_DIRECTORY = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习";

    private static final String FILE_WHOLE = FILE_WHOLE_DIRECTORY+"\\"+FILE_NAME;

    private static final File file =new File(FILE_WHOLE);

    /**
     * FileUtilsTest
     *
     * @description 简单的读取一个文件，利用FileUtils工具类
     * @author wangjing-1
     * @date 2019/8/8 16:54
     * @version v1.0.0
     **/
    static void testReadFileToString() throws IOException {
        String fileToString = FileUtils.readFileToString(file, "UTF-8");
        String fileToString2 = FileUtils.readFileToString(file, Charset.defaultCharset());
        System.out.println(fileToString);
        System.out.println("--------------------------");
        System.out.println(fileToString2);
    }

    static void testReadLines() throws IOException {
        System.out.println(FileUtils.readLines(file, Charset.defaultCharset()));
    }

    static void testWrite() throws IOException {
        FileUtils.write(file, "测试数据", Charset.defaultCharset());
        FileUtils.write(file, "测试数据", Charset.defaultCharset(), true);
    }

    static void testWriteStringToFile() throws IOException {
        FileUtils.writeStringToFile(file, "一串字符", Charset.defaultCharset(), true);
        FileUtils.writeStringToFile(file, "\r\n一串字符", Charset.defaultCharset(), true);
    }

    static void testWriteLines() throws IOException {
        Integer[] numbers ={12,312,312,31,4,34,3124,1325,132,4132,42};
        FileUtils.writeLines(file, Arrays.asList(numbers));
    }

    static void testCopyFile() throws IOException {
        File targetFile = new File(FilenameUtils.getFullPath(FILE_WHOLE)+"测试文件1.0.txt");
        if(!targetFile.exists()){
            targetFile.createNewFile();
        }
        FileUtils.copyFile(file, targetFile);
    }

    static void testListFiles(){
        File fileDirectory = new File(FilenameUtils.getFullPath(FILE_WHOLE));
        for (File listFile : FileUtils
            .listFiles(fileDirectory, new String[] {".txt"}, true)) {
            System.out.println(listFile);
        }
    }


    public static void main(String[] args) throws IOException {
        testListFiles();
    }

}
public class IoUtilsTest {

    public static void main(String[] args){

    }

}


