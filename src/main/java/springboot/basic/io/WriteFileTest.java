/**
 * @projectName springbootTest
 * @package springboot.basic.io
 * @className springboot.basic.io.WriteFileTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

/**
 * WriteFileTest
 *
 * @description 写入文件测试
 * @author wangjing
 * @date 2019/7/31 13:57
 * @version v1.0.0
 */
public class WriteFileTest {

    private static final String FILE_PATH = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习\\测试写入文件.txt";

    private static final String FILE_PATH_READ1 = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习\\测试读取文件1.txt";

    private static final String FILE_PATH_READ2 = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习\\测试读取文件2.txt";

    private static final String FILE_PATH_WRITE3 = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习\\测试写入合并文件.txt";

    private static final String FILE_PATH_MAC = "/work/gitRepo/learn/test.txt";

    static void writeInt(String filePath) throws IOException {
        File file = new File(filePath);
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(97);
        outputStream.close();
    }

    static void writeByte(String filePath) throws IOException {
        File file = new File(filePath);
        OutputStream outputStream = new FileOutputStream(file, true);
        byte[] byt = "测试字符".getBytes("UTF-8");
        outputStream.write(byt);
        outputStream.close();
    }

    static void readAndWriteFile() throws IOException {
        InputStream in1 = new FileInputStream(new File(FILE_PATH_READ1));
        InputStream in2 = new FileInputStream(new File(FILE_PATH_READ2));
        OutputStream ou = new FileOutputStream(new File(FILE_PATH_WRITE3));
        InputStream si = new SequenceInputStream(in1, in2);
        int c = 0;
        while ((c = si.read()) != -1) {
            ou.write(c);
        }
        si.close();
        ou.close();
        in2.close();
        in1.close();
    }

    public static void main(String[] args) throws IOException {
        writeInt(FILE_PATH_MAC);
    }
}
