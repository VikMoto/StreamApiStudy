package streamApi.terminal;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ReduceTest {
    public static void main(String[] args) {

/**
 * Optional<T> reduce(BinaryOperator<T> accumulator)
 *
 * Creates a result by accumulating stream elements. The first element is taken as the base element.
 * flow element and new result is obtained by applying accumulator to base and next
 * flow element. The calculated result becomes the base result and the calculations are repeated for
 * next element.
 * */
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        BinaryOperator<Integer> bop = (a, b) -> a + b;

        Optional<Integer> sum = list.stream()
                .filter(a-> a % 2 == 0)
                .reduce(bop);
//                .reduce((a, b) -> a + b);

        System.out.println(sum.get());

//instead min or max
        List<String> worlds = List.of("Java", "Fortran", "Python", "C++");

        BinaryOperator<String> bop2 = (a, b) -> a.length() > b.length() ? a : b;

        Optional<String> result2 = worlds.stream().reduce(bop2);

        System.out.println(result2.get());

/**
 * Method:
 * T reduce(T identity, BinaryOperator<T> accumulator)
 *
 * Creates a result by accumulating stream elements. The first element is taken as the base element.
 * method parameter and new result is obtained by applying accumulator to base and next
 * flow element. The calculated result becomes the base result and the calculations are repeated for
 * next element. The difference with the previous method is which element is selected as
 * base.
 * */

        List<String> list3 = List.of("world", "!");
        String result3 = list3.stream().reduce("Hello", (a, b) -> a + " " + b);
        System.out.println(result3);
        /**         Hello world !          */



/**
 * Method:
 * <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
 *
 * Creates a result by accumulating stream elements. The first element is taken as the base element.
 * method parameter (it is also returned if the stream is empty) and the new result is obtained by applying
 * accumulator to base element and flow element. Attention! The result and flow element can
 * have different types. The third parameter is used only in parallel streams or in case
 * mismatch between stream and accumulator types.
 * Important conventions for this method:
 * ● The initial value of identity must be consistent with the combiner. For any U u, combiter
 * (identity,u) equals u.
 * ● The accumulator must be matched with the combiner. For any U u, T t must be fulfilled
 * combiner.apply(u, accumulator.apply(identity,t)) == accumulator.apply(u,t)
 * */


        List<Goods> list4 = List.of(new Goods("Apple", 50),
                new Goods("Orange", 70),
                new Goods("Pear", 65),
                new Goods("Cherry", 75));

        BiFunction<Integer, Goods, Integer> biFunc = (a, b) -> {
            System.out.println("biFunc " + "a:" + a + " " + "b:" + b);
            return a + b.getPrice();
        };

        BinaryOperator<Integer> biOp = (a, b) -> {
            System.out.println("biOP " + "a:" + a + " " + "b:" + b);
            return a + b;
        };
        Integer totalSum = list4.stream()
                .filter(a -> a.getPrice() > 65)
                .reduce(0, biFunc, biOp);

        System.out.println(totalSum);
        /**
         * biFunc a:0 b:Goods [name=Orange, price=70]
         * biFunc a:70 b:Goods [name=Cherry, price=75]
         * 145
         * */





/**       BinaryOperator<U> combiner    run only in parallel threads !!!!!!!!!!! */
        List<Goods> list5 = List.of(new Goods("Apple", 50),
                new Goods("Orange", 70),
                new Goods("Pear", 65),
                new Goods("Cherry", 75));

        BiFunction<Integer, Goods, Integer> biFunc5 = (a, b) -> {
            System.out.println("biFunc parallel " + "a:" + a + " " + "b:" + b);
            return a + b.getPrice();
        };

        BinaryOperator<Integer> biOp5 = (a, b) -> {
            System.out.println("biOP parallel " + "a:" + a + " " + "b:" + b);
            return a + b;
        };
        Integer totalSum5 = list4.stream()
                .parallel()
                .reduce(0, biFunc5, biOp5);

        System.out.println(totalSum5);

        /**
         * biFunc parallel a:0 b:Goods [name=Pear, price=65]
         * biFunc parallel a:0 b:Goods [name=Cherry, price=75]
         * biOP parallel a:65 b:75
         * biFunc parallel a:0 b:Goods [name=Orange, price=70]
         * biFunc parallel a:0 b:Goods [name=Apple, price=50]
         * biOP parallel a:50 b:70
         * biOP parallel a:120 b:140
         * 260
         * */
    }
}

class Goods {
    private String name;
    private int price;
    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Goods [name=" + name + ", price=" + price + "]";
    }
}
