package springboot.learn.modifier;

import springboot.learn.modifier.Parent;

public class Child extends Parent{

    @Override
    protected String getS() {
        return super.s;
    }
    
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(Parent.getS2());
        
        Child child = new Child();
        System.out.println(child.getS());
    }
}
