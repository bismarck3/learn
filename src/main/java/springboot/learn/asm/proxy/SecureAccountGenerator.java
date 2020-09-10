/**
 * @projectName learn
 * @package springboot.learn.asm.proxy
 * @className springboot.learn.asm.proxy.SecureAccountGenerator
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.asm.proxy;

import java.io.IOException;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;

import springboot.learn.asm.Account;

/**
 * SecureAccountGenerator
 *
 * @description 
 * @author wangjing
 * @date 2020/9/10 16:51
 * @version v1.0.0
 */
public class SecureAccountGenerator {

    private static AccountGeneratorClassLoader classLoader =
        new AccountGeneratorClassLoader();

    private static Class secureAccountClass;

    public static Account generateSecureAccount()
        throws ClassFormatError, InstantiationException, IllegalAccessException, IOException {
        if (null == secureAccountClass) {
            ClassReader cr = new ClassReader("springboot.learn.asm.Account");
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
            cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
            byte[] data = cw.toByteArray();
            secureAccountClass = classLoader.defineClassFromClassFile(
                "Account$EnhancedByASM",data);
        }
        return (Account) secureAccountClass.newInstance();
    }

    private static class AccountGeneratorClassLoader extends ClassLoader {
        public Class defineClassFromClassFile(String className,
            byte[] classFile) throws ClassFormatError {
            return defineClass("Account$EnhancedByASM", classFile, 0,
                classFile.length);
        }
    }

    public static void main(String[] args) throws IllegalAccessException, IOException, InstantiationException {
        Account account = generateSecureAccount();
        account.operation();
    }
}
