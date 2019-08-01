package springboot.learn.lambda;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Ignore;
import org.junit.Test;
import springboot.learn.bean.User;
import springboot.learn.supplier.UserSupplier;

public class LambdaTest {

    @Ignore
    @Test
    public void testStream() {
        String [] s = new String[] {"1", "2", "3", "4", "6", "7", "8", "9"};
        Stream<String> intList = Arrays.stream(s);
        System.out.println(intList.reduce((a,b) -> "'"+a+"'"+","+"'"+b+"'").get());
        System.out.println(String.join(",", s));
//        Optional<Integer> result = intList.reduce((a, b) -> Math.max(a, b));
//        System.out.println(result.get());
    }
    
//    @Ignore
    @Test
    public void testGroup() {
        Stream<Integer> intList = Arrays.stream(new Integer[] {1, 2, 3, 4, 6, 7, 8, 9});
//        Map<Integer, List<Integer>> collect = intList.collect(Collectors.groupingBy(Person::);
//        System.out.println(collect);
    }
    
    @Ignore
    @Test
    public void testOptional(){
        User user = UserSupplier.getDefaultUser().get();
        String userSchoolCode = Optional.ofNullable(user)
                .map(x->x.getAddress())
                .map(y->y.getCountry())
                .map(z->z.getIsoCode())
                .map(a->a.getCode()).orElse("-----");
        System.out.println(userSchoolCode);
    }
    
    @Ignore
    @Test
  public void testLabmda() {
    Stream<Integer> intList = Arrays.stream(new Integer[] {1, 2, 3, 4, 6, 7, 8, 9});
    Optional<Integer> result = intList.reduce((a, b) -> {
      return Math.max(a, b);
    });
    System.out.println(result.get());
  }
    
    @Ignore
    @Test
    public void test() {
        int value = 4;  //level 1 of stack
        call(
          () -> System.out.println(value) //level 3 of stack
        );
    }
    
    
    
        public static void call(Runnable runnable) {
            System.out.println("calling runnable");
                            
            //level 2 of stack
            runnable.run();
          }
       
}
