/**
 * @projectName learn
 * @package springboot.learn.function
 * @className springboot.learn.function.PredicateMain
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * PredicateMain
 *
 * @description 断言测试
 * @author wangjing
 * @date 2021/5/20 15:35
 * @version v1.0.0
 */
public class PredicateMain {

    public static void main(String[] args) {
        Predicate<Integer> predicate = number -> !number.equals(2);
        Predicate<Integer> predicate2 = number -> !number.equals(5);
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7).filter(predicate.and(predicate2))
            .collect(Collectors.toList());
        System.out.println(list);
    }
}
