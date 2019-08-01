package springboot.learn.protecte;

import springboot.learn.modifier.Parent;

public class Child extends Parent{

    @Override
    protected String getS() {
        return super.s;
    }
    
//    public static void main(String[] args) {
//        Parent parent = new Parent();
//        System.out.println(Parent.getS2());
//        
//        Child child = new Child();
//        System.out.println(child.getS());
//    }
    
    public static void main(String[] args) {
        char c1='a';
        int i1 = c1;
        System.out.println("char自动类型转换为int后的值等于"+i1);
        char c2 = 'A';
        int i2 = c2+1;
        System.out.println("char类型和int计算后的值等于"+i2);
    }
}
