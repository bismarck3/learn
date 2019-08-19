package springboot.basic.extend;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("正方形");
    }
}
