package streamApi.introduction;

import streamApi.introduction.Cat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChangeDataStream {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("Umka", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Luska", 3, "Grey");
        List<Cat> list = List.of(cat1, cat2, cat3, cat4);

        Stream<Cat> catStream = list.stream()
                .filter(a -> a.getWeight() < 5)
                .peek(a -> a.setName("_" + a.getName()));

        catStream.forEach(a -> System.out.println(a));
        for (Cat cat : list) {
            System.out.println("cat = " + cat);
        }

    }
}
