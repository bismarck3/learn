package springboot.learn.function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import org.junit.Ignore;
import org.junit.Test;

import springboot.learn.bean.Person;

public class FunctionTest {

    public static void test(int x, IFunction function) {
        System.out.print(x+"\t");
        function.test();

    }

    @Ignore
    @Test
    public void testMyFunction() {
        System.out.println("--------------------simple Function-----------------");
        //1.实例化
        test(10, new FunctionImp());
        
        //2.匿名内部类
        test(10, new IFunction() {
            
            @Override
            public void test() {
                System.out.println("AAA");
                
            }
        });
        //3.lambda表达式
        test(10, () -> System.out.println("AAA"));
      

    }

    @Ignore
    @Test
    public void testFuntion(){
        System.out.println("--------------------Function-------------------------");
        // 一元函数
        Function<Integer, Integer> func1 = x -> x + 1;
        Function<Integer, Integer> func2 = x -> x * 2;
        Function<Integer, Function<Integer, Integer>> func3 = z -> y -> y + z;
        int x = 1;
        System.out.println("f(x)=x+1,x=" + x + "\t f(x)=" + func1.apply(x));
        System.out.println("f(x)=x+1,g(x)=x*2,x=" + x + "\t f(g(x))=" + func1.compose(func2).apply(x));
        System.out.println("f(x)=x+1,g(x)=x*2,x=" + x + "\t g(f(x))=" + func1.andThen(func2).apply(x));
        System.out.println(func3.apply(1).apply(2));
    }
    
    @Ignore
    @Test
    public void testBiFunction() {
        Function<Integer, Integer> func1 = x -> x + 1;
        System.out.println("-----------------------Function.BiFunction------------");
        // 二元函数
        BiFunction<Integer, Integer, Integer> func4 = (x, y) -> (x * y);
        BiFunction<Integer, Integer, Integer> func5 = (x, y) -> (x + y);
       
        System.out.println("f(z)=x*y:" + func4.apply(1, 2));
        System.out.println("f(z)=x+y:" + func5.apply(1, 2));
        // 二元函数andThen
        System.out.println(func4.andThen(func1).apply(2, 2));
    }

    @Ignore
    @Test
    public void testUnaryOperator() {
        System.out.println("------------------Function.UnaryOperator+Function.BinaryOperator-------------------------");
        UnaryOperator<Integer> operator = z -> z + 1;
        System.out.println(operator.apply(1));
        BinaryOperator<Integer> biOperator = (y, z) -> y + z;
        System.out.println(biOperator.apply(1, 2));
    }

//    @Ignore
    @Test
    public void testPredicate() {
        System.out.println("--------------------------Predicate--------------------------");
        Predicate<Integer> p = z -> z > 1;
        System.out.println(p.and(z -> z < 2).test(2));
        System.out.println(p.test(2));
        System.out.println(p.negate().test(2));
    }

    @Ignore
    @Test
    public void testConsumer() {
        System.out.println("--------------------------Consumer(没有返回值的Function)---------------------------");
        Consumer<Integer> c = b -> System.out.println(b);
        c.accept(100);
    }

    @Ignore
    @Test
    public void testSupplier() {
        System.out.println("-------------------------Supplier(只有返回值的Function)--------------------------------");
        Supplier<Person> supply = Person::new;
        System.out.println(supply.get());

        Supplier<Person> personSupply = () -> {
            Person person = new Person();
            person.setName("wangj");
            return person;
        };
        System.out.println(personSupply.get());
    }
}
