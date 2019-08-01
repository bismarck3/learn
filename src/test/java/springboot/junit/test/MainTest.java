package springboot.junit.test;

import java.math.BigDecimal;
import java.util.Optional;

public class MainTest {

    public static void main(String[] args) {
       Optional.ofNullable(new BigDecimal("xxx")).ifPresent(System.out::println);
    }
}
