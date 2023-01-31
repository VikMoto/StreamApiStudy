package streamApi.terminal;

import java.util.stream.IntStream;

public class IntSreamBuilderTest {
    public static void main(String[] args) {

/**
 * void accept(int t) Adds an element to build the stream. Build phase.
 * */
        String[] languages = new String[] { "Java", "Fortran", "Python" };
        IntStream.Builder builder = IntStream.builder();

        for (String element : languages) {
            builder.accept(element.hashCode());
        }

        IntStream is = builder.build();
        is.forEach(a -> System.out.println(a));


    }
}
