/**
 * @projectName springbootTest
 * @package springboot.basic.io
 * @className springboot.basic.io.FileTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.io;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * FileTest
 *`
 * @description 文件测试
 * @author wangjing
 * @date 2019/7/31 11:27
 * @version v1.0.0
 */
public class FileTest {

    private final static String FILE_PARENT_PATH = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习";

    static void getChildFile() throws IOException {
        File parent = new File(FILE_PARENT_PATH);
        File child = new File(parent, "测试文件.txt");
        System.out.println(child);
    }

    static void getChildrenFilesByFileFilter(){
        File parent = new File(FILE_PARENT_PATH);
        for(File fil : parent.listFiles(pathName -> StringUtils.endsWith(pathName.getName(), ".txt"))){
            System.out.println(fil);
        }
    }

    static void getChildrenFiles(){
        File parent = new File(FILE_PARENT_PATH);
        for(File fil : parent.listFiles()){
            System.out.println(fil);
        }
    }

    static void createFolder(){
        File parent = new File(FILE_PARENT_PATH);
        File child = new File(parent, "测试文件");
        child.mkdir();
    }

    static void createFolders(){
        File parent = new File(FILE_PARENT_PATH);
        File child = new File(parent, "\\1\\2\\3\\测试文件2");
        child.mkdirs();
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        getChildrenFiles();
    }
}
