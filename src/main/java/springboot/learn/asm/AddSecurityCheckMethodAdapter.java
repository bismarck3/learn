/**
 * @projectName learn
 * @package springboot.learn.asm
 * @className springboot.learn.asm.AddSecurityCheckMethodAdapter
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.asm;

import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

/**
 * AddSecurityCheckMethodAdapter
 *
 * @description 
 * @author wangjing
 * @date 2020/9/10 16:29
 * @version v1.0.0
 */
public class AddSecurityCheckMethodAdapter extends MethodAdapter {
    public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
        super(mv);
    }

    public void visitCode() {
        visitMethodInsn(Opcodes.INVOKESTATIC, "SecurityChecker",
            "checkSecurity", "()V");
    }
}
