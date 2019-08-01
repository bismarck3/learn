package springboot.learn.modifier;

public class Parent {

    protected String s = "123";
    
    private static String s2 = "456";
    
    protected String getS() {
        return this.s;
    }

    public void setS(String s) {
        this.s = s;
    }
    
    
    protected static String getS2() {
        return s2;
    }
}
