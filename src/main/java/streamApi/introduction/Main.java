package streamApi.introduction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        List<Integer> list1 = List.of(0, 3, -2, 4, -1, 7);
//        list1.stream()
//                .filter(a -> a > 0)
//                .sorted()
//                .forEach(a -> System.out.println(a));

        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("Umka", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Luska", 3, "Grey");
        List<Cat> list = List.of(cat1, cat2, cat3, cat4);
        int age = 5;
//        List<Cat> result= list.stream()
//                .filter(a->a.getName().length() >= 4)
//                .filter(a->a.getWeight() >= age)
//                .collect(Collectors.toList());
//        System.out.println(result);

        Stream<String> stringStream = list.stream()
                .filter(a -> a.getWeight() >= age)
                .map(a -> a.getName());

        List<String> collect = stringStream.collect(Collectors.toList());
        System.out.println(collect);

/**
 *****************   to look in each method in stream:   ***********************************
 * */
        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

    }
}