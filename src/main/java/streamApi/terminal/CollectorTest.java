package streamApi.terminal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;

public class CollectorTest {
    public static void main(String[] args) {
        List<Integer> list = List.of(0, -2, 3, 4, 2, -4, 7, 5, 0);
        System.out.println("list = " + list);
        Predicate<Integer> predicate = (a) -> a > 0;
        Collector<Integer, List<Integer>, List<Integer>> collector = new NumberClassificator(predicate);
        List<Integer> result = list.stream().collect(collector);
        System.out.println(result);
    }
}

class NumberClassificator implements Collector<Integer, List<Integer>, List<Integer>> {
    private Predicate<Integer> addOrNot;
    public NumberClassificator(Predicate<Integer> addOrNot) {
        super();
        this.addOrNot = addOrNot;
    }
    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }
    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return (a, b) -> {
            if (addOrNot.test(b)) {
                a.add(b);
            }
        };
    }
    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (a, b) -> {
            List<Integer> result = new ArrayList<>();
            result.addAll(a);
            result.addAll(b);
            return result;
        };
    }
    @Override
    public Function<List<Integer>, List<Integer>> finisher() {
        return (a) -> {
            List<Integer> sortedList = new ArrayList<>();
            sortedList.addAll(a);
            Collections.sort(sortedList);
            return sortedList;
        };
    }
    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}