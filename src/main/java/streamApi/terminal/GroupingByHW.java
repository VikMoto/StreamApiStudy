package streamApi.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupingByHW {
    /**
     * Collect the elements of the stream of integers in two lines (one for even numbers, the second for odd
     * numbers) use ";" as separator.
     *
     * */


    public static void main(String[] args) {
        List<Integer> listNumber2 = List.of(1, 2, 3, 4, 5);
        Map<String, List<Integer>> result4 = listNumber2.stream()
                .collect(Collectors.groupingBy(a -> (a % 2 == 0) ? "even" : "odd"));
        System.out.println("result4 = " + result4);
/**          result4 = {even=[2, 4], odd=[1, 3, 5]}         */


        final List<Object> collect = result4.entrySet()
                .stream()
                .flatMap( n -> Arrays.stream(n.getValue().toArray()))
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);

        String even = listNumber2.stream()
                .filter(a -> a % 2 == 0)
                .map(a -> a.toString())
                .collect(Collectors.joining("; "));

        String odd = listNumber2.stream()
                .filter(a -> a % 2 != 0)
                .map(a -> a.toString())
                .collect(Collectors.joining("; "));

        System.out.println("even = " + even);
        System.out.println("odd = " + odd);

//        Collector<Integer, ?, List<Integer>> downstream = Collectors.toList();
//
//        Function<List<Integer>, List<String>> finisher = a -> {
//            List<String> result = new ArrayList<>();
//            for (Integer element : a) {
//                result.add((Integer.toString(element)).repeat(element));
//            }
//            return result;
//        };
//
//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        List<String> result = list.stream()
//                .collect(Collectors.collectingAndThen(downstream, finisher));
//
//        System.out.println("result = " + result);
//
//        /**       result = [1, 22, 333, 4444, 55555]        */
    }
}
