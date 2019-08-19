package springboot.basic.reflect;

public class YourClassIsWrongException extends RuntimeException {
    public YourClassIsWrongException(ClassNotFoundException e) {
    }
}
