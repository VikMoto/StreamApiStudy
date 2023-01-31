package streamApi.terminal;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrimeNumberFromTo {
    public static void main(String[] args) {
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
    }

}
