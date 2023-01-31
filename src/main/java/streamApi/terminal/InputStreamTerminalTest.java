package streamApi.terminal;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class InputStreamTerminalTest {
    public static void main(String[] args) {

/**
 * OptionalDouble average() Average calculation
 * OptionalInt max() Returns the maximum
 * OptionalInt min() Returns the minimum
 * IntSummaryStatistics summaryStatistics() Return statistics
 * */
        IntStream is = IntStream.of(new int[] { 0, -2, 5, 10, 3 });

        IntSummaryStatistics stat = is.summaryStatistics();

        System.out.println("Max = " + stat.getMax());
        System.out.println("Min = " + stat.getMin());
        System.out.println("Average = " + stat.getAverage());
        System.out.println("Sum = " + stat.getSum());
    }
}
