package streamApi.terminal;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StatisticFromStreamTest {
    public static void main(String[] args) {
        List<String> names = List.of("Katia", "Alexander", "Olga", "Inna");

        ToIntFunction<String> mapper = a -> a.length();

        Collector<String, ?, Double> collector1 = Collectors.averagingInt(mapper);

        double average = names.stream().collect(collector1);

        System.out.println("average = " + average);

        long total = names.stream().count();
        System.out.println(total);

        long totalSum = names.stream().collect(Collectors.summingInt(mapper));
        System.out.println(totalSum);

        IntSummaryStatistics istat = names
                .stream()
                .collect(Collectors.summarizingInt(mapper));

        System.out.println("Sum = " + istat.getSum());
        System.out.println("Average = " + istat.getAverage());
        System.out.println("Max = " + istat.getMax());
        System.out.println("Min = " + istat.getMin());
        System.out.println("Count = " + istat.getCount());

        /**
         * average = 5.5
         * 4
         * 22
         * Sum = 22
         * Average = 5.5
         * Max = 9
         * Min = 4
         * Count = 4
         * */
    }
}
