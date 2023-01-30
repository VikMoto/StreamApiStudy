package streamApi.terminal;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorGroupingByTest {
    public static void main(String[] args) {
        Collector<String, Map<String, Integer>, Map<String, Integer>> collector = new GroupByEquals<>();
        String text = "hello world";
        Map<String, Integer> result = Arrays.stream(text.split("")).collect(collector);
        System.out.println(result);

        Collectors.toSet();

        /**
         * { =1, r=1, d=1, e=1, w=1, h=1, l=3, o=2}
         * */
    }

}

class GroupByEquals<T> implements Collector<T, Map<T, Integer>, Map<T, Integer>> {
    /**
     * key - this is element of stream
     * value - count how much this element repeat
     * */

    @Override
    public Supplier<Map<T, Integer>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<T, Integer>, T> accumulator() {
        return (map1, element) -> {
            Integer n = map1.getOrDefault(element, 0);
            map1.put(element, n + 1);
        };
    }

    private static int countVowels(String s) {
        return s.replaceAll("[^aieouy]", "").length();
    }

    @Override
    public BinaryOperator<Map<T, Integer>> combiner() {
        return (map1, map2) -> {
            Map<T, Integer> result = new HashMap<>(map1);
            map2.forEach((k, v) -> {
                Integer n = result.getOrDefault(k, 0);
                result.put(k, v + n);
            });
            return result;
        };
    }

    @Override
    public Function<Map<T, Integer>, Map<T, Integer>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED);
    }
}