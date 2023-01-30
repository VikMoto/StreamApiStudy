package streamApi.Intermediate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringVowelsSortedHW {
    public static void main(String[] args) throws IOException {
/**
 * Break a string of English text on a space character. Sort the resulting set of words in
 * ascending order of the number of vowels in it. Words that do not have vowels
 * excluded from the result.
 * */

        List<String> strings = Files.lines(Path.of("test.txt"))
                .map(a -> a.split(" "))
                .flatMap( a -> Stream.of(a))
                .filter(a -> countVowels(a) != 0)
                .sorted( (a, b) -> countVowels(a) - countVowels(b) )
                .collect(Collectors.toList());
        System.out.println("strings = " + strings);

    }

    private static int countVowels(String s) {
        return s.replaceAll("[^aieouy]", "").length();
    }
}
