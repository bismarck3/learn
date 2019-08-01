/**
 * @projectName springbootTest
 * @package springboot.basic.reflect.io
 * @className springboot.basic.reflect.io.InputStreamExtendsTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.reflect.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStreamExtendsTest
 *
 * @description 输入流子类
 * @author wangjing
 * @date 2019/7/31 14:39
 * @version v1.0.0
 */
public class InputStreamExtendsTest {

    private static final String FILE_PATH = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习\\测试读取文件.txt";

    static void readByte(InputStream inputStream) throws IOException {
        int byt = 0;
        while((byt=inputStream.read())!= -1){
            System.out.println((char)byt);
        }
    }

    static void byteArrayInputStream() throws IOException {
        byte[] temp = "abc".getBytes("UTF-8");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(temp);
        readByte(byteArrayInputStream);
    }

    static void fileInputStream() throws IOException {
        File file = new File(FILE_PATH);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStream inputStream = new FileInputStream(fileInputStream.getFD());
        readByte(inputStream);
    }

    static void dataInputStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{12,3,12});
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        System.out.println(dataInputStream.readByte());
    }

    public static void main(String[] args) throws IOException {
        byteArrayInputStream();
    }

}
