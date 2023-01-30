package streamApi.terminal;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalFindAnyFindFirst {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(0, 8, 4, 6, 3, 10, 5);
        Stream<Integer> stream = numbers.stream().filter(n -> n % 2 == 1);
        Optional<Integer> result = stream.findFirst();
        System.out.println(result.get());
    }
}
