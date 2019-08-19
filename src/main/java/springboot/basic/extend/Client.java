package springboot.basic.extend;

import java.util.ArrayList;
import java.util.List;

public class Client {



    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Shape circle = new Circle();
        if(Shape.class.isInstance(circle)){
            Square square = (Square)circle;
        }
        if(Shape.class.equals(Circle.class)){

        }
    }
}
