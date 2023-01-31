package streamApi.terminal;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitioningByTest {
    public static void main(String[] args) {

/**
 * static <T> Collector<T,?,Map<Boolean,List<T>>> partitioningBy(Predicate<? super T>
 * predicate)
 * */

        List<Integer> listNumber = List.of(1, 2, 3, 4, 5);

        Predicate<Integer> predicate = a -> a % 2 == 0;

        Map<Boolean, List<Integer>> result = listNumber.stream()
                .collect(Collectors.partitioningBy(predicate));
        System.out.println("result = " + result);
    }
}
