/**
 * @projectName springbootTest
 * @package springboot.junit.test
 * @className springboot.junit.test.test
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.junit.test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;


/**
 * test
 * @description 
 * @author wangj
 * @date 2018年8月30日 下午7:59:34
 * @version 
 */
public class test {

    @Test
    @Ignore
    public void tes(){
        List<String> selectedList = Arrays.asList("A", "B", "C", "D");
        List<String> data = new ArrayList<>(selectedList);
        data.removeIf(x->x.equals("A"));
        System.out.println(data);
//        selectedList.add("E");
//        selectedList.remove("A");
//        System.out.println(selectedList);
    }
    
    @Ignore
    @Test
    public void mainTest(){
        Integer number = 1332;
        Integer sum = 4568;
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);
        String result = numberFormat.format((float)number/(float)sum*100)+"%";
        System.out.println(result);
    }

    
    class Fater{
        public void func(Map<?, ?> p) {
            System.out.println("父类");
        }
    }
    
    class Child extends Fater{
        @Override
        public void func(Map<?, ?> p) {
            System.out.println("子类");
        }
    }
    
    @Test
    public void test() {
        Stream<String> stream = Stream.of();
       System.out.println( stream.findFirst().orElse("123"));
    }
}
