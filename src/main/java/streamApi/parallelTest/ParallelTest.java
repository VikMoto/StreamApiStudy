package streamApi.parallelTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ParallelTest {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Integer result = list
                .parallelStream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(result);

/**
 * An example of incorrect work
 * */
        List<String> list2 = List.of("Hello", "Java", "world");
        String result2 = list2
                .parallelStream()
                .reduce("result = ", (a, b) -> a + " " + b);
        System.out.println(result2);
/**
 * In the case of a serial stream, we would get
 *  * result = Hello Java world.
 *
 * Actual result:
 * result =  Hello result =  Java result =  world
 *
 * */

/** method:
 *  <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
 *
 * Creates a result by accumulating stream elements. The first element is taken as the base element.
 * method parameter (it is also returned if the stream is empty) and the new result is obtained by applying
 * accumulator to base element and flow element. Attention! The result and flow element can
 * have different types. The third parameter is used only in parallel streams or in case
 * mismatch between stream and accumulator types.
 *
 *
 *
 * When working with parallel streams, it is worth remembering about
 * combining results
 * */

        String[] languages = new String[] { "Java", "Fortran", "Python" };
        String start = "languages = ";
        BinaryOperator<String> combiner = (a, b) -> {
            System.out.println("combiner a = " + a + "   b = " + b);
            if (b.startsWith(start)) {
//                return a + b.substring(start.length());
                return a + b.substring(start.length());
            }
            return a + b;
        };
        BiFunction<String, String, String> reduceFunction = (a, b) -> a + " " + b;
        String result3 = Arrays
                .stream(languages)
                .parallel()
                .reduce(start, reduceFunction, combiner);
        System.out.println(result3);

        /**
         * combiner a = languages =  Fortran   b = languages =  Python
         * combiner a = languages =  Java   b = languages =  Fortran Python
         * languages =  Java Fortran Python
         * */

        /**
         * Начальное значение identity должно быть согласованно с combiner. Для любого U u, combiter
         * (identity,u) equals u.
         * identity = "languages = ", u = "languages = Fortran" => languages = Fortran
         * ● аccumulator должен быть согласован с combiner. Для любого U u, T t должно выполнятся
         * combiner.apply(u, accumulator.apply(identity,t)) == accumulator.apply(u,t)
         * identity = "languages = ", u = "languages = Fortran", t = "Java" => languages = Fortran
         * Java = languages = Fortran Java
         * */
    }

}
