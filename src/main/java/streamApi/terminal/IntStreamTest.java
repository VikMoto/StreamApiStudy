package streamApi.terminal;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {

/**
 * The static method of(..) will create a stream based on an enum of elements
 * */
        IntStream is1 = IntStream.of(1, 2, 3, 4, 5, 6);

        is1.filter(a -> a > 2).forEach(a -> System.out.println(a));

        IntStream is2 = IntStream.of(new int[] { 1, 2, 3, 4 });

        is2.filter(a -> a % 2 == 0).forEach(a -> System.out.println(a));

/**
 * Static method range(start, end) Will create an integer stream, values from start to end (does not include
 * last value). DoubleStream does not have this method.
 * */

        IntPredicate iPred = n -> {
    /************   Prime number true or false *****************/
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };
        IntStream is = IntStream.range(2, 100);
        is.filter(iPred).forEach(a -> System.out.print(a + " "));


/**
 * Static method rangeClosed(start, end) Creates an integer stream, values from
 * start to end (includes last value). DoubleStream does not have this method.
 * */
    }
}



