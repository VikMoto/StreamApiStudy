package streamApi.Intermediate;

import streamApi.introduction.Cat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateTest {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("UmkA", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Kuzia", 3, "Grey");
        Cat cat5 = new Cat("Hug", 1, "Black");
        Cat cat6 = new Cat("Barsic", 2, "Red");
        Cat cat7 = new Cat("Barsic", 6, "RedWhite");

        List<Cat> cats = List.of(cat1,cat2,cat3,cat4, cat5, cat6, cat7);
        System.out.println("cats = " + cats);

//        List<String> catsFilter = cats.stream()
//                .filter(a -> a.getWeight() <= 5)
//                .map( a -> a.getName() + " " + a.getWeight())
/**
 * In this example, the data flow type is changed. Based on the list
 * a Stream<Cat> is created. The filter method leaves only cats lighter than 5 kg in it,
 * after which with map changes the stream type from Cat to String.
 * */
//                .collect(Collectors.toList());
//        System.out.println("catsFilter = " + catsFilter);

/**************************************************************************************
 * <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
 * method which creates, based on each data element of the current thread, a new thread
 * at the same time laying the created flows into a single one.
 * ************************************************************************************
 * */

//        System.out.println();
//        System.out.println("__________________________________________________________________");
//        Singer singer1 = new Singer("Freddie Mercury", new String[] { "We Are the Champions", "Somebody to Love" });
//        Singer singer2 = new Singer("David Bowie",new String[] { "Space Oddity", "Let Me Sleep Beside You", "Suffragette City" });
//        Singer singer3 = new Singer("James Paul McCartney", new String[] { "Can’t Buy Me Love", "Another Girl" });
//        Singer[] rockStars = new Singer[] { singer1, singer2, singer3 };
//
//        List<String> song = Arrays.stream(rockStars)
//                .flatMap(n-> Arrays.stream(n.getSongs()))
//                .collect(Collectors.toList());
//        System.out.println(song);

/**
 * Методы:
 * DoubleStream flatMapToDouble(Function<? super T,? extends DoubleStream> mapper)
 * IntStream flatMapToInt(Function<? super T,? extends IntStream> mapper)
 * LongStream flatMapToLong(Function<? super T,? extends LongStream> mapper)
 * Данные методы порождают потоки примитивного типа (примитивные специализации Stream) на
 * основании каждого элемента текущего потока. Порожденные потоки «укладываются» в общий
 * порожденный поток.
 * */

//        System.out.println();
//        System.out.println("__________________________________________________________________");
//
//        String[] array = new String[] { "C", "Java", "Fortran" };
//        Arrays.stream(array)
//                .forEach(System.out::println);
//
//        IntStream stream = Arrays.stream(array).flatMapToInt(n -> n.codePoints());
//        stream.forEach(n -> System.out.print(n + " "));

/**************************************************************************************
 * Method static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
 * This method is used to concatenate streams. Those. combining the data of two streams into
 * one stream. If order-preserving streams are used, then the data of stream b follows after
 * stream data a.
 * */
//        System.out.println();
//        System.out.println("__________________________________________________________________");
//
//        List<Integer> list1 = List.of(0, 2, 4, 6);
//        List<Integer> list2 = List.of(1, 3, 5, 7);
//        Stream<Integer> stream1 = list1.stream();
//        Stream<Integer> stream2 = list2.stream();
//
//        Stream<Integer> concatStream = Stream.concat(stream1, stream2);
//        concatStream.forEach(n -> System.out.print(n + ", "));

/***************************************************************************************
 * static <T> Stream<T> empty() method
 * This method is used to create an empty stream. A stream is created in which there
 * are no data elements.
 * *************************************************************************************
 * */
//        System.out.println();
//        System.out.println("__________________________________________________________________");
//
//        Stream<Integer> stream3 = Stream.empty();
//        stream3.forEach(n -> System.out.println(n));

/**************************************************************************************
 * Method static <T> Stream<T> generate(Supplier<? extends T> s)
 * This method is used to create an endless stream of data based on data
 * generated using the Supplier implementation. Attention created flow is infinite,
 * so in if it is necessary to collect the data of the stream into a data structure,
 * it must be limited (for example, using the limit method).
 * ************************************************************************************
 * */

//        System.out.println();
//        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//
//        Stream<Integer> stream4 = Stream.generate(getRandomNumber(1, 10));
//        List<Integer> listRand = stream4
//                .limit(100)
//                .collect(Collectors.toList());
//        System.out.println(listRand);

/***************************************************************************************
 * Метод static <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext,
 * UnaryOperator<T> next) Данный метод применяется для создания потока данных на
 * основании данных генерируемых с помощью применения реализации UnaryOperator к seed,
 * данные будут генерироваться до тех пор пока Predicate возвращает true. Важное
 * замечание что next применяется к результату работы предыдущего
 * вызова этого же метода. seed это начальное значение задаваемое явно.
 * *************************************************************************************
 * */

        Stream.iterate(1, n -> n <= 10, n -> n + 1)
        .forEach(n -> System.out.print(n + " "));


/***************************************************************************************
 * Method static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
 * This method is used to create an endless stream of data based on data
 * generated by applying the UnaryOperator implementation to seed. Important note that
 * next applied to the result of a previous call to the same method. seed is the
 * initial value given explicitly. The created stream is infinite, so it should be
 * limited (for example, with using the limit method).
 * *************************************************************************************
 * */
        System.out.println();

        Stream<String> stream5 = Stream.iterate("A*", n -> n + n);
//Using the iterate method, we get a Stream<String>. As initial value
//the value "A" is used. At each step, the result of the last call is appended to the
// line. But there is no termination condition. Therefore, this kind of flow needs to
// be limited.
        stream5 .limit(4)
                .forEach(n -> System.out.println(n));

/***************************************************************************************
 * Methods
 * static <T> Stream<T> of(T t)
 * static <T> Stream<T> of(T...values)
 * These methods create a stream either based on a single element or based on several
 * elements. Basically, it's just another way to create a stream based on the data you
 * have.
 * *************************************************************************************
 * */
        System.out.println();
        List<String> stringList = Stream.of("Hello", "World").collect(Collectors.toList());
        System.out.println("stringList = " + stringList);

        Stream<String> stream7 = Stream.of(new String[]{"method", "returns true", "then the hashCode()", "method on", "each of", "those two", "objects must return"});
        List<String> list = stream7.collect(Collectors.toList());
        System.out.println(list);

/*************************************************************************************************
 * Method
 * static <T> Stream<T> ofNullable(T t)
 * This method creates a stream based on a single element. If it is not null then the stream
 * will be contain a single element, otherwise an empty stream will be returned.
 * ***********************************************************************************************
 * */

        Stream<String> stream1 = Stream.ofNullable("Hello");
        stream1.forEach(n -> System.out.println(n));
        Stream<String> stream2 = Stream.ofNullable(null);
        stream2.forEach(n -> System.out.println(n));
//The example creates two threads. The first contains one element, and the second is empty.

    }
    public static Supplier<Integer> getRandomNumber(int start, int end) {
        class RandGen implements Supplier<Integer> {
            @Override
            public Integer get() {
                return (int) (start + Math.random() * (end - start) + 1);
            }
        }
        return new RandGen();
    }
}
