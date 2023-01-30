package streamApi.Intermediate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderTest {
    public static void main(String[] args) {

/**
 * Intermediate methods that do not change the order of the stream are executed one after the other.
 * one for each data element. Those. first one element is taken and for it
 * the entire sequence of intermediate methods and the terminal one are executed.
 * */

        List<String> list1 = List.of("A1", "A2", "A3");
        Stream<String> stream = list1.stream()
                .filter(n -> {
                    System.out.println("Filter " + n);
                    return n.length() <= 2;
                })
                .map(n -> {
                    System.out.println("Map " + n);
                    return "_" + n;
                });
//        stream.forEach(n -> System.out.println("forEach " + n));
/**
 * Filter A1
 * Map A1
 * forEach _A1
 * Filter A2
 * Map A2
 * forEach _A2
 * Filter A3
 * Map A3
 * forEach _A3
 * */

        System.out.println("----------------------------------------");
        List<String> list2 = List.of("A1", "A2", "A3");
        Stream<String> stream2 = list2.stream()
                .map(n -> {
                    System.out.println("Map " + n);
                    return "_" + n;
                })
                .filter(n -> {
                    System.out.println("Filter " + n);
                    return n.endsWith("2");
                });
//        stream2.forEach(n -> System.out.println("forEach " + n));

//        System.out.println("----------------------------------------");
        List<String> list3 = List.of("A1", "A2", "A3");
        Stream<String> stream3 = list3.stream()
                .filter(n -> {
                    System.out.println("Filter " + n);
                    return n.endsWith("2");
                })
                .map(n -> {
                    System.out.println("Map " + n);
                    return "_" + n;
                });
//        stream3.forEach(n -> System.out.println("forEach " + n));

/**
 *              Stateful Methods
 *
 * Some intermediate methods for reordering a stream are
 * stateful methods. In particular, this is the sorted method. They are
 * use "horizontal" processing of data elements. Those. first accumulate
 * all elements of the stream, perform the operation and spawn a stream
 * based on the result.
 * */
        List<String> list4 = List.of("A1", "C1", "B1");
        Stream<String> stream4 = list4.stream()
                .sorted((a,b)->{ //Accumulation states
                    System.out.println("Sorted "+a+" "+b);
                    return a.compareTo(b);
                })
                .filter(n -> {
                    System.out.println("Filter " + n);
                    return n.startsWith("B");
                }).map(n -> {
                    System.out.println("Map " + n);
                    return "_" + n;
                });
        stream4.forEach(n -> System.out.println("forEach " + n));

/***********************************************************************************
 *
 * Recommendations for working with memory methods states
 *
 * If possible, try to use stateful methods with
 * the minimum number of elements in the stream, since these methods are the most
 * resource intensive. Those. try to sort the stream data (or change the order of the data
 * in the stream) as close as possible to the terminal methods.
 *
 *
 * *********************************************************************************
 * */




/***********************************************************************************
 *                            sorted(Comparator<? super T> comparator)
 ***********************************************************************************
 * */

        List<Integer> list = List.of(-2, 4, 0, -5, 3, 2, 5, 1);
        System.out.println("list before sort = " + list);
        List<Integer> result = list.stream()
                .sorted((a,b)-> Math.abs(a)-Math.abs(b))
                .collect(Collectors.toList());
        System.out.println("list after sort = " + result);
/**
 * list before sort = [-2, 4, 0, -5, 3, 2, 5, 1]
 * list after sort = [0, 1, -2, 2, 3, 4, -5, 5]
 * */


/***********************************************************************************
 *                            sorted() natural order
 ***********************************************************************************
 * */
        System.out.println("-----------------------------------------------------");

        List<Integer> list5 = List.of(-2, 4, 0, -5, 3, 2, 5, 1);
        System.out.println("list before sort = " + list5);
        List<Integer> result2 = list5.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("list after sort = " + result2);
/**
 * list before sort = [-2, 4, 0, -5, 3, 2, 5, 1]
 * list after sort = [-5, -2, 0, 1, 2, 3, 4, 5]
 * */

    }
}
