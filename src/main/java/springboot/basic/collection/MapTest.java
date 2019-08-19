package springboot.basic.collection;

import springboot.basic.reflect.entity.User;

import java.util.*;

public class MapTest {

    static void testHashMap(){
        Map<String, String> data = new HashMap<>();
        data.put("1", "A");
        data.put("2", "B");

        System.out.println(data.get("1"));
    }

    static void testLinkedHashMap(){
        Map<String, String> data = new LinkedHashMap<>();
        data.put("1", "A");
    }

    static void testSortedHashMap(){
        Map<User, String> data = new TreeMap<>();
        data.put(new User(), "A");
        data.put(new User(), "B");

    }

    public static void main(String[] args) {
        testHashMap();
    }
}
