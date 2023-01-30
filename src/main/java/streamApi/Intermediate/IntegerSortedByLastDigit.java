package streamApi.Intermediate;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerSortedByLastDigit {
    public static void main(String[] args) {

/**
 * From the list of integers, select those values of which are greater than 10, sort by value
 * display the result on the screen for the last digit.
 *
 * */
        List<Integer> integerList = List.of(3, 5, 12, 3554, 25, 745, 16, 28881, 24, 64);
        System.out.println("integerList = " + integerList);
        List<Integer> collect = integerList.stream()
                .filter(i -> i >= 10)
                .sorted( (a, b) -> (a % 10) - (b % 10))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
/**
 * integerList = [3, 5, 12, 3554, 25, 745, 16, 28881, 24, 64]
 * collect = [28881, 12, 3554, 24, 64, 25, 745, 16]
 * */

    }
}
