package springboot.basic.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface HasBatteries{}

interface Waterproof{}

interface Shoots{}

class Toy{
    Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    FancyToy(){super(1);}
}


@SuppressWarnings("rawtypes")
public class ClassMethodTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(ClassMethodTest.class);
    

    
    static void printNameInfo(Class clazz) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Class name: " + clazz.getName()+" is interface? ["+clazz.isInterface()+"]");
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println("Canonical name: " + clazz.getCanonicalName());
    }
    
    static void printInterfaceInfo(Class clazz) {
        for(Class interfac: clazz.getInterfaces()) {
            printInterfaceInfo(interfac);
        }
    }
    
    static void printSuperClassInfo(Class clazz) {
        Class supr = clazz.getSuperclass();
        Object obj = null;
        try {
            obj = supr.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("获取类实例失败:"+clazz.getName(), e);
        } 
        printNameInfo(obj.getClass());
    }

    /**
     * ClassMethodTest
     * 类型转换前做检查
     **/
    static void classTypeCheck(){
        Toy toy = new FancyToy();
        System.out.println(toy instanceof Toy );
        System.out.println(toy instanceof FancyToy );
        System.out.println(Toy.class.isInstance(toy));
        System.out.println(FancyToy.class.isInstance(toy));
        System.out.println(FancyToy.class.isAssignableFrom(FancyToy.class));
        System.out.println(Toy.class.isAssignableFrom(FancyToy.class));
    }

    /**
     * ClassMethodTest
     * Instanceof与Class的等价性
     **/
    static void classToInstanceof(){


    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("springboot.basic.reflect.FancyToy");
            printNameInfo(c);
            printInterfaceInfo(c);
            printSuperClassInfo(c);
        } catch (ClassNotFoundException e) {
            LOGGER.error("无法加载到类", e);
        }
    }
}
