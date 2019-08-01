package springboot.learn.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Ignore;
import org.junit.Test;
import springboot.learn.bean.Person;


public class StreamTest {

  private List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
  private List<Integer> list2 = Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16);
  private List<Integer> list3 = Arrays.asList(17, 18, 19, 20, 21, 22, 23, 24);

  @Ignore
  @Test
  public void test() {
    List<Integer> list4 = Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16);
    System.out.println(list4);
    // System.out.println(list.stream().anyMatch(list2::contains));
  }

  @Ignore
  @Test
  public void testMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("1", 1);
    Object computeIfPresent = map.computeIfPresent("1", (x, y) -> 3);
    System.out.println(map);
    Object computeIfAbsent = map.computeIfAbsent("2", x -> 3);
    System.out.println(map);
    System.out.println(computeIfPresent);
    System.out.println(computeIfAbsent);
  }


  @Ignore
  @Test
  public void testStreamMap() {
    List<Person> personList = new ArrayList<Person>();
    for (int i = 0; i < 10; i++) {
      Person person = new Person();
      person.setAge(i + 1);
      person.setName(String.valueOf((char) ('A' + i)));
      personList.add(person);
    }
    Map<Integer, Object> dataMap = personList.stream().filter(person -> person.getAge() > 5)
        .collect(Collectors.toMap(Person::getAge, Person::getName));
    System.out.println(dataMap);
    Map<Integer, List<Person>> collect =
        personList.stream().collect(Collectors.groupingBy(Person::getAge));
    System.out.println(collect);


    // List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
    // List<Integer> list2 = Arrays.asList(2131,2,3,4,123,6,56,23,1);
    // System.out.println(list.stream().anyMatch(list2::contains));
  }

  @Ignore
  @Test
  public void testFltMapDifferentfMap() {
    // map
    List<List<Integer>> returnData = Stream.of(list, list2, list3).collect(Collectors.toList());
    System.out.println(returnData);

    List<Integer> listData =
        Stream.of(list, list2, list3).flatMap(a -> a.stream()).collect(Collectors.toList());
    System.out.println(listData);
  }

  @Ignore
  @Test
  public void testPeek() {
    list.stream().peek(x -> System.out.println(x)).map(y -> Math.exp(y))
        .peek(x -> System.out.println(x)).collect(Collectors.toList());
  }

  @Ignore
  @Test
  public void testPeek2() {
    List<Integer> list = new ArrayList<>();
    List<Integer> lis = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    List<Double> list2 = lis.stream().peek(x -> list.add((x + 10000))).map(y -> Math.sqrt(y))
        .collect(Collectors.toList());
    System.out.println(list);
    System.out.println(list2);
  }

  @Ignore
  @Test
  public void testForeach() {
    List<Long> list = new ArrayList<>();
    for (Long i = 0L; i < 10000000L; i++) {
      list.add(i);
    }
    Long startTimeStamp = System.currentTimeMillis();
    for (Long number : list) {
      number = number + 1000;
    }
    Long endTimeStamp = System.currentTimeMillis();
    System.out.println(endTimeStamp - startTimeStamp);
  }

  @Ignore
  @Test
  public void testStrem() {
    List<Long> list = new ArrayList<>();
    for (Long i = 0L; i < 10000000L; i++) {
      list.add(i);
    }
    Long startTimeStamp = System.currentTimeMillis();
    list.stream().map(x -> x + 1000).collect(Collectors.toList());
    Long endTimeStamp = System.currentTimeMillis();
    System.out.println(endTimeStamp - startTimeStamp);
  }

  @Ignore
  @Test
  public void testParallel() {
    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
    List<Long> list = new ArrayList<>();
    for (Long i = 0L; i < 100000000L; i++) {
      list.add(i);
    }
    Long startTimeStamp = System.currentTimeMillis();
    list.parallelStream().map(x -> x + 1000).collect(Collectors.toList());
    Long endTimeStamp = System.currentTimeMillis();

    System.out.println(endTimeStamp - startTimeStamp);
  }
}
