/**
 * @projectName learn
 * @package springboot.learn.asm
 * @className springboot.learn.asm.AddSecurityCheckClassAdapter
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.asm.proxy;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

import springboot.learn.asm.AddSecurityCheckMethodAdapter;

/**
 * AddSecurityCheckClassAdapter
 *
 * @description asm-adaptor
 * @author wangjing
 * @date 2020/9/10 16:28
 * @version v1.0.0
 */
public class AddSecurityCheckClassAdapter extends ClassAdapter {

    private String enhancedSuperName;

    public AddSecurityCheckClassAdapter(ClassVisitor cv) {
        //Responsechain 的下一个 ClassVisitor，这里我们将传入 ClassWriter，
        // 负责改写后代码的输出
        super(cv);
    }

    public void visit(final int version, final int access, final String name,
        final String signature, final String superName,
        final String[] interfaces) {
        String enhancedName = name + "$EnhancedByASM";  // 改变类命名
        enhancedSuperName = name; // 改变父类，这里是”Account”
        super.visit(version, access, enhancedName, signature,
            enhancedSuperName, interfaces);
    }

    public MethodVisitor visitMethod(final int access, final String name,
        final String desc, final String signature, final String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv = mv;
        if (mv != null) {
            if (name.equals("operation")) {
                wrappedMv = new AddSecurityCheckMethodAdapter(mv);
            } else if (name.equals("<init>")) {
                wrappedMv = new ChangeToChildConstructorMethodAdapter(mv,
                    enhancedSuperName);
            }
        }
        return wrappedMv;
    }
}
