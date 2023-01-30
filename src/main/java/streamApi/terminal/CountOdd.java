package streamApi.terminal;

import java.util.List;
import java.util.stream.Stream;

public class CountOdd {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(0, 8, 4, 6, 3, 10, 5);
        Stream<Integer> stream = numbers.stream().filter(n -> n % 2 == 1);
        long odd = stream.count();
        System.out.println(odd);
    }
}
