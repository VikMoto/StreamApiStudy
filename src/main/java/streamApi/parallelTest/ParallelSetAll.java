package streamApi.parallelTest;

import java.util.Arrays;
import java.util.function.IntFunction;

public class ParallelSetAll {
    public static void main(String[] args) {
/**
 *
 * public static <T> void parallelSetAll(T[] array, IntFunction<? extends T> generator)
 *
 *  * Sets each element of an array using the implementation to generate the element
 * IntFunction. Where the index of the element is used as a parameter.
 * * */

        String[] names = new String[] { "Alex", "Olga", "Inna", "Viktor", "Anna" };
        String[] array = new String[8];

        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
        // i % names.length залишок від ділення індекса на довжину масиву
        // - циклічне заповнення другого масиву
        IntFunction<String> generator = (i) -> names[i % names.length];

        Arrays.parallelSetAll(array, generator);

        System.out.println(Arrays.toString(array));
        /**
         * Alex Olga Inna Viktor Anna
         * [Alex, Olga, Inna, Viktor, Anna, Alex, Olga, Inna]
         * */


    }
}
