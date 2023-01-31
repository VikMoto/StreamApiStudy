package streamApi.terminal;

import java.util.stream.IntStream;

public class AsIntStreamTest {
    public static void main(String[] args) {
        IntStream is = IntStream.range(1, 100);

        Double sum = is.asDoubleStream().sum();

        System.out.println(sum);
    }
}
