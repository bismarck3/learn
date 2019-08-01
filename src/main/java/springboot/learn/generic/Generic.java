package springboot.learn.generic;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Generic<T, U> {

    public <R> List<R> translateReturnData(List<T> jfxxppVos, Function<T,R> function){
        return jfxxppVos
            .stream()
            .map(function)
            .collect(Collectors.toList());
    }
    
    
//    public <R> List<R> translateReturnData(List<T> jfxxppVos, Function<T,R> function, Function<T,U> function2){
//        return jfxxppVos
//            .stream()
//            .map(function)
//            .sorted(Comparator.comparing(function2))
//            .collect(Collectors.toList());
//    }
}
