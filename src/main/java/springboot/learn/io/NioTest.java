/**
 * @projectName learn
 * @package springboot.learn.io
 * @className springboot.learn.io.NioTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NioTest
 *
 * @description nio
 * @author wangjing
 * @date 2020/9/7 14:40
 * @version v1.0.0
 */
public class NioTest {

    public static void main(String[] args) throws IOException {
        outputStream();
    }

    private static void outputStream() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\lenovo\\Desktop\\test.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer.wrap(new byte[]{97, 98, 99, 100});
        channel.write(buffer);
    }

    private static void inputStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\lenovo\\Desktop\\test.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (channel.read(buffer) != -1) {
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println((char)buffer.get());
        }
    }
}
