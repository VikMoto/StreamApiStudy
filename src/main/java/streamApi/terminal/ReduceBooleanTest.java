package streamApi.terminal;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class ReduceBooleanTest {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);
        Predicate<Integer> predicate = a -> a % 2 == 0;
        BiFunction<Boolean, Integer, Boolean> biFun = (a, b) ->{
            System.out.println("biFunc  " + "a:" + a + " " + "b:" + b);
            return a && predicate.test(b);
        };
        BinaryOperator<Boolean> biOp = (a, b) -> {
            System.out.println("biOP " + "a:" + a + " " + "b:" + b);
            return a && b;
        };
        Boolean identity = true;
        Boolean allMathc = list.stream().reduce(identity, biFun, biOp);
        System.out.println(allMathc);
    }
}
