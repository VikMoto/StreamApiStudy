package streamApi.terminal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxedTest {
    public static void main(String[] args) {
        IntStream is = IntStream.rangeClosed(1, 10);
        System.out.println("is = " + is);

        List<Integer> result = is.boxed().collect(Collectors.toList());

        System.out.println(result);
    }
}
