/**
 * @projectName springbootTest
 * @package springboot.basic.io
 * @className springboot.basic.io.OutPutStreamExtendsTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.io;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * OutPutStreamExtendsTest
 *
 * @description 输入流子类
 * @author wangjing
 * @date 2019/7/31 15:49
 * @version v1.0.0
 */
public class OutPutStreamExtendsTest {

    static void testByteArrayOutputStream() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(97);
        System.out.println(byteArrayOutputStream.toString());
    }

    static class InputStreamRunnable implements Runnable {
        private PipedInputStream pis = null;

        public InputStreamRunnable(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            BufferedReader sr = new BufferedReader(new InputStreamReader(pis));
            try {
                System.out.println("读取到的内容:" + sr.readLine());
                sr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static class OutputStreamRunnable implements Runnable {
        private PipedOutputStream pos = null;

        public OutputStreamRunnable(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try {
                pos.write("Hello World!".getBytes());
                pos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void threadPipeTest(){
        PipedOutputStream pos = new PipedOutputStream();
        try {
            PipedInputStream pis = new PipedInputStream(pos);
            new Thread(new InputStreamRunnable(pis)).start();
            new Thread(new OutputStreamRunnable(pos)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        threadPipeTest();
    }
}
