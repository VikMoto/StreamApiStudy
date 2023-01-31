package streamApi.terminal;

import java.io.File;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CollectorsClassTest {
    public static void main(String[] args) {
/**  static <T,K,U>Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K>
*    keyMapper, Function<? super T,? extends U> valueMapper)
*/

        List<Integer> listNumber = List.of(1, 2, 3, 4, 5);
        List<Integer> result = listNumber.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(result);


        Map<Integer, String> result2 = listNumber.stream()
                .collect(Collectors
                        .toMap(Function.identity(), a -> (a % 2 == 0) ? " even":" odd"));

        System.out.println("result2 = " + result2);

/**
 * static <T,K,U> Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K>
 * keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U>
 * mergeFunction, Supplier<M> mapFactory)
 * */
        Function<Integer, String> keyMapper = a -> (a % 2 == 0) ? "even" : "odd";

        Function<Integer, List<Integer>> valueMapper = a -> List.of(a);

        BinaryOperator<List<Integer>> mergeFunction = (a, b) -> {
            List<Integer> result3 = new ArrayList<>(a);
            result3.addAll(b);
            return result3;
        };
        Supplier<Map<String, List<Integer>>> supplier = HashMap::new;

        Map<String, List<Integer>> result3 = listNumber.stream()
                .collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction, supplier));

        System.out.println("result3 = " + result3);
/**          result3 = {even=[2, 4], odd=[1, 3, 5]}         */

/**
 * static <T,K> Collector<T,?,Map<K,List<T>>> groupingBy(Function<? super T,? extends
 * K> classifier)
 * */
        List<Integer> listNumber2 = List.of(1, 2, 3, 4, 5);
        Map<String, List<Integer>> result4 = listNumber2.stream()
                .collect(Collectors.groupingBy(a -> (a % 2 == 0) ? "even" : "odd"));
        System.out.println("result4 = " + result4);
/**          result4 = {even=[2, 4], odd=[1, 3, 5]}         */



    }
}
