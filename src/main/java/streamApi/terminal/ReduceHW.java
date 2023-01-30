package streamApi.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceHW {


    public static void main(String[] args) throws IOException {
        
/************************************************************************************
 * Break a string of English text on a space character. Using reduce return the total
* the number of letters in words longer than 4.
*************************************************************************************
*/

        BiFunction<Integer, String, Integer> biFunc = (a, b) -> {
                    System.out.println("biOP " + "a:" + a + " " + "b:" + b);
                        return (a + b.length());};


        final Integer reduce = Files.lines(Path.of("test2.txt"))
                .flatMap(a -> Stream.of(a.split(" ")))
                .filter(a -> a.length() >= 4)
//                .reduce(0, biFunc, (a, b) -> a + b);
                .reduce(0, (a, b) -> {
                    System.out.println("biOP " + "a:" + a + " " + "b:" + b);
                        return (a + b.length());} ,
                        (a, b) -> a + b );
        /**
         * biOP a:0 b:Creates
         * biOP a:7 b:result
         * biOP a:13 b:accumulating
         * biOP a:25 b:stream
         * biOP a:31 b:elements.
         * reduce = 40
         * */

        System.out.println("reduce = " + reduce);
        System.out.println();
/************************************************************************************
 * Using reduce, return the multiply of the elements of the stream given a list of integers
 * numbers.
 *************************************************************************************
 */
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        BinaryOperator<Integer> bop = (a, b) -> {
            System.out.println("biOP " + "a:" + a + " " + "b:" + b);
            return a * b;};

        Optional<Integer> sum = list.stream()
//                .filter(a-> a % 2 == 0)
                .reduce(bop);
//                .reduce((a, b) -> a + b);

        System.out.println(sum.get());
        /**
         * biOP a:1 b:2
         * biOP a:2 b:3
         * biOP a:6 b:4
         * biOP a:24 b:5
         * biOP a:120 b:6
         * biOP a:720 b:7
         * biOP a:5040 b:8
         * 40320
         * */

/************************************************************************************
 * Replace with the reduce method the terminal method max
 *************************************************************************************
 */

        List<Integer> list2 = List.of(1, 2, 9, 4, 5, 6, 7, 8);

        BinaryOperator<Integer> bop2 = (a, b) -> {
            System.out.println("biOP " + "a:" + a + " " + "b:" + b);
            return a > b ? a: b;};

        Optional<Integer> sum2 = list2.stream()
//                .filter(a-> a % 2 == 0)
                .reduce(bop2);
//                .reduce((a, b) -> a + b);

        System.out.println(sum2.get());
    }
}
