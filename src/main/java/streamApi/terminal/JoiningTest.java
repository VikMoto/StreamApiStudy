package streamApi.terminal;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningTest {
    public static void main(String[] args) {
        List<String> names = List.of("Katia", "Alexander", "Olga", "Inna");

        String result = names
                .stream()
                .collect(Collectors.joining(", ", "Hello ", "!"));

        System.out.println(result);

        /**
         * Hello Katia, Alexander, Olga, Inna!
         * */
    }
}
