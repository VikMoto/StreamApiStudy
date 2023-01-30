package streamApi.terminal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CollectorsClassTest {
    public static void main(String[] args) {
        List<Integer> listNumber = List.of(1, 2, 3, 4, 5);
        List<Integer> result = listNumber.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(result);


        Map<Integer, String> result2 = listNumber.stream()
                .collect(Collectors
                        .toMap(Function.identity(), a -> (a % 2 == 0) ? " even":" odd"));

        System.out.println("result2 = " + result2);





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
    }
}
