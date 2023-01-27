package streamApi.Intermediate;

import streamApi.introduction.Cat;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterTest {
    public static void main(String[] args) {
        List<Integer> list = List.of(0, 5, -2, 1, -4, 7);

        List<Integer> resultList = list.stream().filter(n -> n > 0).collect(Collectors.toList());

        System.out.println(resultList);

        List<Integer> list2 = List.of(0, 2, -2, 1, -4, 6);
        List<Integer> resultList2 = list2.stream()
                .filter(n -> n > 0)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(resultList2);

        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("UmkA", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Kuzia", 3, "Grey");
        Cat cat5 = new Cat(null, 7, "Black");
        Cat cat6 = new Cat("Barsic", 2, "Red");
        Cat cat7 = new Cat("Barsic", 2, "Red");

        Cat [] cats = new Cat[] {cat1,cat2,null,cat3,cat4};

        Stream<Cat> catToName = Arrays.stream(cats)
                .filter(Objects::nonNull)
                .filter(a -> a.getWeight() > 5);
        try {
            List<Cat> result = catToName.collect(Collectors.toList());
            System.out.println(result);
        }catch (NullPointerException e) {
            System.out.println(e);
        }

        List<Integer> list3 = List.of(0, 5, -2, 0, 3, 1, 1, -4, 7);
        System.out.println("list3 = " + list3);
        list3.stream()
                .distinct()
                .forEach(n -> System.out.print(n + " "));
/**
 * There are two equivalent objects in the list, but since the equals method in the Cat class is not
 * implemented, the default implementation of equals is used. As a result, the distinct method
 * does not remove equivalent objects from the stream. This is because the implementation of equals
 * By default, it compares not the state of objects, but the addresses of links.
 * */

        Cat[] cats2 = new Cat[] { cat1, cat2, cat3, cat4, cat5, cat6, cat7 };
        Stream<Cat> catToName2 = Arrays.stream(cats2).distinct();
        catToName2.forEach(n -> System.out.println(n));

/**
 * The skip(long n) method is used to skip the first n in the stream
 * elements. This method makes sense for order-preserving streams or
 * ordered streams.
 * */
        List<Integer> list4 = List.of(0, 5, -2, 0, 3, 1, 1, -4, 7);
        System.out.println("list4 = " + list4);
        list4.stream()
                .filter(n -> n >= 0)
                .sorted()
//                .skip(4)
/** list4 = [0, 5, -2, 0, 3, 1, 1, -4, 7]
 0 0 1 1 3 5 7  */
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("************************************************************");

/**
 * Default method default Stream<T> dropWhile(Predicate<? super T> predicate)
 * is used to remove the first portion of stream elements for which the implementation
 * Predicate will return true.
 * */

        List<Integer> list5 = List.of(0, 5, -2, 0, 3, 1, 1, -4, 7);
        System.out.println("list5 = " + list5);
        list5.stream()
/** Predicate which is used in the dropWhile method
 becomes true on the first positive number in the stream, and removes all elements
 flow to the first element for which Predicate will return false. So out of the flow
 the first two numbers will be removed.
 */
                .dropWhile(n -> n >= 0)
                .forEach(n -> System.out.print(n + ", "));
        /**
         * list5 = [0, 5, -2, 0, 3, 1, 1, -4, 7]
         * -2, 0, 3, 1, 1, -4, 7
         * */
        System.out.println();
        System.out.println("************************************************************");

/**
 *The default method takeWhile(Predicate<? super T> predicate) is used to
 * to leave in the stream the first portion of the stream elements for which the implementation
 * Predicate will return true. The rest of the stream elements will be discarded
 * */
        System.out.println("list5 = " + list5);
        list5.stream()
/**
 * In this example, the implementation of the Predicate that is used in the takeWhile
 * method becomes true on the first positive number in the stream, and leaves everything
 * in the stream elements of the stream up to the first element for which Predicate will
 * return false. Those. first two numbers.
 * */
                .takeWhile(n -> n >= 0)
                .forEach(n -> System.out.print(n + ", "));

                /**
                 * list5 = [0, 5, -2, 0, 3, 1, 1, -4, 7]
                 * 0, 5,
                 * */

    }
}
