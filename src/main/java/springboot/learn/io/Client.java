/**
 * @projectName learn
 * @package springboot.learn.io
 * @className springboot.learn.io.Client
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * Client
 *
 * @description cleint
 * @author wangjing
 * @date 2020/9/7 14:57
 * @version v1.0.0
 */
public class Client {

    public static void client() throws IOException, InterruptedException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("172.25.8.68",8099));
        if(socketChannel.finishConnect())
        {
            int i=0;
            while(true)
            {
                TimeUnit.SECONDS.sleep(1);
                String info = "I'm "+i+++"-th information from client";
                buffer.clear();
                buffer.put(info.getBytes());
                buffer.flip();
                while(buffer.hasRemaining()){
                    System.out.println(buffer);
                    socketChannel.write(buffer);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        client();
    }
}
