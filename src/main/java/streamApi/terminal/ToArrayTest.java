package streamApi.terminal;

import java.util.Arrays;
import java.util.List;

public class ToArrayTest {
    public static void main(String[] args) {

/**
 * Object[] toArray()
 *
 * Returns an array based on the elements of the stream.
 * */
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Object[] result = numbers.stream().filter(a -> a % 2 == 0).toArray();

        System.out.println(Arrays.toString(result));


/**
 * <A> A[] toArray(IntFunction<A[]> generator)
 *
 * Returns an array based on the elements of the stream. The method parameter is a binary
 * a specialization of IntFunction that returns an array of the desired type. The most commonly used link to
 * constructor.
 * */
        List<String> names = List.of("Alexander", "Olga", "Inna", "Katia");
        String[] result2 = names.stream().limit(2).toArray(String[]::new);
        System.out.println(Arrays.toString(result2));

    }
}
