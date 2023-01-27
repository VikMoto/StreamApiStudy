package streamApi.introduction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExeptionInStream {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat(null, 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Luska", 3, "Grey");
        List<Cat> list = List.of(cat1, cat2, cat3, cat4);

        Stream<Cat> catStream = list.stream()
                .filter(a -> a.getName().length() > 5);
        try {
            List<Cat> collect = catStream.collect(Collectors.toList());
            System.out.println("collect = " + collect);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
