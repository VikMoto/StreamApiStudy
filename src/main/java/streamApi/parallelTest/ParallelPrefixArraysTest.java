package streamApi.parallelTest;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class ParallelPrefixArraysTest {
    public static void main(String[] args) {
/**
 * public static <T> void parallelPrefix(T[] array,BinaryOperator<T> op)
 * public static <T> void parallelPrefix(T[] array, int fromIndex, int toIndex, BinaryOperator<T> op)
 *
 * These methods carry out changes to array elements using the accumulating function
 * BinaryOperator. The initial value is the first element in the array, or
 * the element at the specified index (when using the second version).
 * */

        BinaryOperator<String> binOp = (a, b) -> a + " " + b;

        String[] language = new String[] { "Java", "Fortran", "Python" };

        Arrays.parallelPrefix(language, binOp);

        System.out.println(Arrays.toString(language));

/**
 * We calculate the total profit for a certain period using parallelPrefix. For this
 * sum the profit for the previous months with the profit for the current month by changing the value of the element.
 * It is important to use the primitive specializations of the appropriate interfaces.
 * */
        int[] profit = new int[] { 10_000, 12_000, 15_000 };

        IntBinaryOperator binOp2 = (a, b) -> a + b;

        Arrays.parallelPrefix(profit, binOp2);

        System.out.println(Arrays.toString(profit));
    }
}
