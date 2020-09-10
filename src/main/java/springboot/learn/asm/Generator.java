/**
 * @projectName learn
 * @package springboot.learn.asm
 * @className springboot.learn.asm.Generator
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.asm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;

/**
 * Generator
 *
 * @description 
 * @author wangjing
 * @date 2020/9/10 16:30
 * @version v1.0.0
 */
public class Generator{

    private static void generateClass() throws IOException {
        ClassReader cr = new ClassReader("springboot.learn.asm.Account");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
        cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();
        File file = new File("Account.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();
    }

    private static void account(){
        Account account = new Account();
        account.operation();
    }

    public static void main(String[] args) throws IOException {
        generateClass();
//        account();
    }
}
