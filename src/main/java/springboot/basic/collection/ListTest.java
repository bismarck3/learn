package springboot.basic.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(3);
        numbers.addAll(numbers2);

        for (int i = 0; i < numbers.size(); i++) {
            numbers.get(i);
        }

        for (Integer number : numbers) {
        }

        Iterator<Integer> numberIterator = numbers.iterator();
        while(numberIterator.hasNext()){
            Integer nextNumber = numberIterator.next();
        }

        ListIterator<Integer> integerListIterator = numbers.listIterator();
        integerListIterator.previous();

    }
}
