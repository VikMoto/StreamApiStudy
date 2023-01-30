package streamApi.terminal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectTest {
    public static void main(String[] args) {
/**
 * Method:
 * <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
 * Creates a result by accumulating the elements of a stream into a data structure (most commonly used
 * Collection implementation). The first parameter is the Supplier supplier responsible for creating
 * the desired mutable data structure (List, Set, Queque). Second parameter BiConsumer accumulator
 * takes the created data structure (first parameter) and the stream element as a parameter
 * (second parameter) and adds the stream element or the result of its processing to the data structure.
 * The third parameter of the BiConsumer combiner is used in parallel streams to collect the results
 * each thread into the overall result.
 * An important condition should be the coordination of the operation of the accumulator and combiner. It means that
 * executing accumulator entirely in one serial stream should give the same
 * the result is the same as processing a part of the stream using the accumulator and then merging these parts
 * using a combiner.
 * */


        List<Integer> list1 = List.of(1, 2, 3, 4);

        List<Integer> even = list1.stream()
                .filter(a-> a % 2 ==0)
                .collect(ArrayList::new, (a, b)-> a.add(b), (a, b)-> a.addAll(b));
        System.out.println("even = " + even);

/** Class Goods see in ReduceTest */
        List<Goods> list = List.of(new Goods("Apple", 50),
                new Goods("Orange", 70),
                new Goods("Pear", 65),
                new Goods("Cherry", 75));
        List<String> goodsName = list.stream()
                .filter(a -> a.getPrice() > 50)
                .collect(ArrayList::new,(a, b) -> a.add(b.getName()),
                        (a, b)-> a.addAll(b) );//combine several from different threads Lists into one
        System.out.println("goodsName = " + goodsName);

/**
 * grouping of elements of stream
 * */
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, List<Integer>> result = numbers.stream()
                .collect(CollectTest::createMap, CollectTest::addToMap, CollectTest::mergeMap);
        System.out.println(result);
    }

    public static Map<String, List<Integer>> createMap() {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("even", new ArrayList<>());
        map.put("odd", new ArrayList<>());
        return map;
    }
    public static void addToMap(Map<String, List<Integer>> map, Integer element) {
        if (element % 2 == 0) {
            map.get("even").add(element);
        } else {
            map.get("odd").add(element);
        }
    }
    public static void mergeMap(Map<String, List<Integer>> map1, Map<String, List<Integer>> map2) {
        map2.forEach((k, v) -> map1.get(k).addAll(v));
    }
}

