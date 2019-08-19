package springboot.basic.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Candy{
    static {
        System.out.println("Candy");
    }
}

class Gum{
    static {
        System.out.println("Gum");
    }
}

class Cookie{
    static {
        System.out.println("Cookie");
    }
}



public class ClassLoadTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(ClassLoadTest.class);
    
    public static void main(String[] args) throws ClassNotFoundException {
        classLoad();
    }

    private static void testLoad() {
        System.out.println("main");
        new Candy();
        try {
            Class.forName("Gum");
//            Class<Gum> gum = Gum.class;
        }catch (Exception e) {
            LOGGER.error("无法找到为名为Gum的类", e);
        }
        System.out.println("After load Gum");
        new Cookie();
        System.out.println("after create cookie");
    }

    static void classLoad() throws ClassNotFoundException {
//        new Candy();
        Candy candy = new Candy();
        Class<?> aClass1 = Class.forName("");
        Class<? extends Candy> aClass = candy.getClass();
        Class gum = Gum.class;
    }

}
