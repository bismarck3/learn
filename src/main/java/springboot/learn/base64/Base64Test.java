package springboot.learn.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String base64encodedString = Base64.getEncoder().encodeToString("java8".getBytes("utf-8"));
        
       
        // 解码
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
       
        System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
        System.out.println("Base64 加密后" + base64encodedString);
        
    }
}
