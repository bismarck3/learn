/**
 * @projectName springbootTest
 * @package springboot.basic.io
 * @className springboot.basic.io.ReadFileTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ReadFileTest
 *
 * @description 读取文件
 * @author wangjing
 * @date 2019/7/31 9:52
 * @version v1.0.0
 */
public class ReadFileTest {

    private static final String FILE_PATH = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习\\测试读取文件.txt";

    /**
     * ReadFileTest
     * 以字节流的方式读取文件
     **/
    static void readByte(String filePath) throws IOException{
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        int byt = 0;
        while((byt=inputStream.read())!= -1){
            System.out.println(byt);
            System.out.println((char)byt);
        }
    }

    static void readChar(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        // 也可以使用缓冲区，避免重复读取
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());
        int byt = 0;
        char[] temp = new char[200];
        while((byt=inputStreamReader.read(temp))!= -1){
            System.out.println(temp);
        }
    }

    public static void main(String[] args) throws IOException {
        readByte(FILE_PATH);
    }
}
