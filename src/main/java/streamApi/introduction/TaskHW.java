package streamApi.introduction;

import streamApi.introduction.Cat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskHW {
    public static void main(String[] args) throws IOException {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("Umka", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Luska", 3, "Grey");
        List<Cat> list = List.of(cat1, cat2, cat3, cat4);

/**
 * Using the Stream API and List<Cat>, return the longest cat name in this list.
 * */
        String name = list.stream()
                .max((a, b) -> a.getName().length() - b.getName().length())
                .get()
                .getName();
        System.out.println("name = " + name);

/**
 * Using the Stream API and List<Integer>, select only odd numbers, sort them
 * ascending and collect in a new list.
 * */
    List<Integer> integerList = List.of(43,2,5,87,3,51,40,12,13,15,22,31);
        List<Integer> integers = integerList.stream()
                .filter(a -> a % 2 != 0)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("integerList = " + integerList);
        System.out.println("integers = " + integers);

/**
 * Using the Stream API, return the address of the file with the maximum size in the specified
 * Catalog.
 * */

        Files.lines(Path.of("d:\\Code\\Video\\Tsymbaliuk"))
                .
    }
}
