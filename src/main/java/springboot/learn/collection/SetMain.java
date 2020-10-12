/**
 * @projectName learn
 * @package springboot.learn.collection
 * @className springboot.learn.collection.SetMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * SetMain
 *
 * @description 
 * @author wangjing
 * @date 2020/9/29 11:43
 * @version v1.0.0
 */
public class SetMain {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(set);
        Stream.of(set.toArray()).forEach(System.out::print);
        System.out.println();
        Stream.of(set.toArray(new Integer[0])).forEach(System.out::print);
    }
}
