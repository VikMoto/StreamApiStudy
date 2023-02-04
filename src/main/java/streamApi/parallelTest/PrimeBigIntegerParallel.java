package streamApi.parallelTest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeBigIntegerParallel {
    public static void main(String[] args) {

        Predicate<BigInteger> predicate = (a) -> {
            for (BigInteger i = BigInteger.valueOf(2); i.compareTo(a) < 0; i = i.add(BigInteger.ONE)) {
                if (a.mod(i).equals(BigInteger.ZERO)) {
                    return false;
                }
            }
            return true;
        };

        Supplier<List<BigInteger>> supplier = ArrayList::new;

        BiConsumer<List<BigInteger>, BigInteger> accumulator = (a, b) -> a.add(b);

        BinaryOperator<List<BigInteger>> combiner = (a, b) -> {
            List<BigInteger> result = Collections.synchronizedList(new ArrayList<>());
            result.addAll(a);
            result.addAll(b);
            return result;
        };
        Function<List<BigInteger>, List<BigInteger>> finisher = Function.identity();


        Random rnd = new Random();

        List<BigInteger> numbers = Stream
                .generate(() ->
                        BigInteger.valueOf(Math.abs(rnd.nextInt(1_000_000))))
                .limit(100_00)
                .collect(Collectors.toList());

        long t1 = System.nanoTime()/1000000;

        List<BigInteger> result1 = numbers
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());

        long t2 = System.nanoTime()/1000000;

        System.out.println((t2 - t1) + " ns, result = " + result1.size());

        long t3 = System.nanoTime()/1000000;

        List<BigInteger> result2 = numbers
                .parallelStream()
                .filter(predicate)
                .collect(Collector
                        .of(supplier, accumulator, combiner, finisher,
                                Collector.Characteristics.CONCURRENT));
        long t4 = System.nanoTime()/1000000;

        System.out.println((t4 - t3) + " ms, result = " + result2.size());
    }
}
