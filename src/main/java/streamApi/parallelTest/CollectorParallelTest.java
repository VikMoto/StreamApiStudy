package streamApi.parallelTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorParallelTest {
    public static void main(String[] args) {
        Supplier<List<Integer>> supplier = ArrayList::new;

        BiConsumer<List<Integer>, Integer> accumulator = (a, b) -> a.add(b);

        BinaryOperator<List<Integer>> combiner = (a, b) -> {
            System.out.println("Combiner : a = " + a + "  b = " + b);
            List<Integer> result = Collections.synchronizedList(new ArrayList<>());
            result.addAll(a);
            result.addAll(b);
            return result;
        };
        Function<List<Integer>, List<Integer>> finisher = Function.identity();
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("list = " + list);

        List<Integer> result = list.parallelStream()
                .filter(a -> a % 2 == 0)
                .collect(Collector.of(supplier, accumulator, combiner, finisher, Collector.Characteristics.CONCURRENT));
        System.out.println(result);

        /**
         * list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
         * Combiner : a = []  b = [4]
         * Combiner : a = []  b = [6]
         * Combiner : a = []  b = [2]
         * Combiner : a = [8]  b = []
         * Combiner : a = []  b = [8]
         * Combiner : a = [2]  b = [4]
         * Combiner : a = [6]  b = [8]
         * Combiner : a = [2, 4]  b = [6, 8]
         * [2, 4, 6, 8]
         * */
    }
}
