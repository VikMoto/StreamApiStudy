package streamApi.terminal;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Predicate<Integer> predicate = a -> a > 3;

        Collector<Integer, ?, List<Integer>> collector = Collectors.toList();
        List<Integer> result = list.stream()
                .collect(Collectors.filtering(predicate, collector));
        System.out.println("result = " + result);
    }
}
