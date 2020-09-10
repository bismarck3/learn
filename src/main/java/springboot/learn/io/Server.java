/**
 * @projectName learn
 * @package springboot.learn.io
 * @className springboot.learn.io.Server
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Server
 *
 * @description server
 * @author wangjing
 * @date 2020/9/7 14:57
 * @version v1.0.0
 */
public class Server {

    public static void server() throws IOException {
        ServerSocket serverSocket;
        InputStream in;
        serverSocket = new ServerSocket(8099);
        int recvMsgSize;
        byte[] recvBuf = new byte[1024];
        while (true) {
            Socket clntSocket = serverSocket.accept();
            SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
            System.out.println("Handling client at " + clientAddress);
            in = clntSocket.getInputStream();
            while ((recvMsgSize = in.read(recvBuf)) != -1) {
                byte[] temp = new byte[recvMsgSize];
                System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
                System.out.println(new String(temp));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        server();
    }
}
