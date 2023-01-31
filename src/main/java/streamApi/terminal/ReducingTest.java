package streamApi.terminal;

import java.util.List;
import java.util.stream.Collectors;

public class ReducingTest {
    public static void main(String[] args) {
        List<Integer> listNumber = List.of(1, 2, 3, 4, 5);
        Integer result = listNumber.stream()
                .collect(Collectors.reducing(0, (a, b) -> a + b));
        System.out.println("result = " + result);
    }
}
