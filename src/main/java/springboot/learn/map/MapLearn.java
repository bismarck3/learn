package springboot.learn.map;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapLearn {

    public static void main(String[] args) {
        submap();
    }

    private static void submap() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        SortedMap<String, String> subMap = map.subMap("2", true, "2", true);
        System.out.println(subMap.values());
    }

    private static void stream() {
        Map<String, String> map =
            Stream.of("1", "2", "3", "4", "5").collect(Collectors.toMap(String::new, String::new));
        System.out.println(map);
        Map<String, String> map2 =
            Stream.of("①", "②", "③", "④", "⑤").collect(Collectors.toMap(String::new, String::new));

        System.out.println(map2);
    }

}
