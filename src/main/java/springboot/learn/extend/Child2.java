package springboot.learn.extend;

import java.io.InputStream;

import aj.org.objectweb.asm.ClassReader;

public class Child2 extends AbstractParent{

//    @Override
//    InputStream testExtend(ByteArrayInputStream inputStream) throws Exception {
//        System.out.println("InputStream");
//        return null;
//    }

    InputStream testExtend(InputStream inputStream) throws Exception {
        System.out.println("InputStream");
        return null;
    }
    
    InputStream testExtend(ClassReader inputStream) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("ClassReader");
        return null;
    }
    
    public static void main(String[] args) throws Exception {
        Child2 child2 = new Child2();
        child2.testExtend(new ClassReader(new byte[1024]));
    }
}
