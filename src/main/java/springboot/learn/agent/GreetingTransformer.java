/**
 * @projectName learn
 * @package springboot.learn.agent
 * @className springboot.learn.agent.GreetingTransformer
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.time.LocalDateTime;

/**
 * GreetingTransformer
 *
 * @description 
 * @author wangjing
 * @date 2020/9/9 11:36
 * @version v1.0.0
 */
public class GreetingTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
        ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if("springboot.learn.agent.Dog".equals(className)){
            System.out.println("method invoke\t" + LocalDateTime.now());
        }
        return null;
    }
}
