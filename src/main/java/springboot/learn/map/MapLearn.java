package springboot.learn.map;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapLearn {

  public static void main(String[] args) {
      Map<String, String> map = Stream.of("1","2","3","4","5")
          .collect(Collectors.toMap(String::new , String::new));
      System.out.println(map);
      Map<String, String> map2 = Stream.of("①","②","③","④","⑤")
          .collect(Collectors.toMap(String::new , String::new));
      
       System.out.println(map2);
  }
  
}
