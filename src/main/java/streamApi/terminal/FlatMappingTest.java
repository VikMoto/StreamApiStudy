package streamApi.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMappingTest {
    public static void main(String[] args) {
        List<String> language = List.of("Python", "Java", "Fortran");

        Function<String, Stream<String>> mapper = a -> Arrays.stream(a.split(""));

        BinaryOperator<Integer> mergeFunction = (a, b) -> a + b;

        Collector<String, ?, Map<String, Integer>> downstream =
                Collectors.toMap(Function.identity(), a -> 1,mergeFunction);

        Map<String, Integer> result = language
                .stream()
                .collect(Collectors.flatMapping(mapper, downstream));
        System.out.println("result = " + result);
        /**
         * result = {P=1, a=3, r=2, t=2, F=1, v=1, h=1, y=1, J=1, n=2, o=2}
         * */
    }
}
