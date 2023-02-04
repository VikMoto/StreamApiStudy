package streamApi.parallelTest;

import java.util.Arrays;
import java.util.Comparator;

public class ParallelSort {
    public static void main(String[] args) {
/**
 * static <T extends Comparable<? super T>> void parallelSort(T[] a)
 * static <T extends Comparable<? super T>> void parallelSort(T[] a, int fromIndex, int toIndex)
 * static <T> void parallelSort(T[] a, int fromIndex, int toIndex, Comparator<? super T> cmp)
 * static <T> void parallelSort(T[] a, Comparator<? super T> cmp)
 *
 * These method sets function similarly to the sort methods. The difference is
 * that sorting works in parallel mode. Namely, merge sort is used, where
 * sorting of an individual block is performed in a separate thread. The algorithm is adaptive, so if
 * the array size is less than a certain size, then it is sorted by the usual sort method.
 * */
        Comparator<Integer> comparator = (a, b) -> Integer.bitCount(a) - Integer.bitCount(b);
//bitCount(a) - return count 1 in binary representation

        Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (Integer integer : array) {
            System.out.print(" " + integer);
        }
        System.out.println();

        Arrays.parallelSort(array, comparator);

        System.out.println(Arrays.toString(array));

/**
 * In the above example, an array of integers is sorted in parallel. criterion
 * sorting is the number of 1 bits in the binary representation of a number.
 * */
    }
}
