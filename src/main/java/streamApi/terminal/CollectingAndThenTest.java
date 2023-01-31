package streamApi.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectingAndThenTest {
    public static void main(String[] args) {
        Collector<Integer, ?, List<Integer>> downstream = Collectors.toList();

        Function<List<Integer>, List<String>> finisher = a -> {
            List<String> result = new ArrayList<>();
            for (Integer element : a) {
                result.add((Integer.toString(element)).repeat(element));
            }
            return result;
        };

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<String> result = list.stream()
                .collect(Collectors.collectingAndThen(downstream, finisher));

        System.out.println("result = " + result);

       /**       result = [1, 22, 333, 4444, 55555]        */
    }
}
