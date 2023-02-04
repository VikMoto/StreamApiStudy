package streamApi.parallelTest;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class FactorialParallelSetAll {
    public static void main(String[] args) {
        int[] array = new int[6];

        IntUnaryOperator generator = FactorialParallelSetAll::factorial;

        Arrays.parallelSetAll(array, generator);

        System.out.println(Arrays.toString(array));
    }
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
