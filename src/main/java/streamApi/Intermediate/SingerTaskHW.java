package streamApi.Intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SingerTaskHW {
    public static void main(String[] args) {
        /**************************************************************************************
         * 2) Based on an array of rock artists, create a list of the first (alphabetical) three songs.
         * ************************************************************************************
         * */


        System.out.println("__________________________________________________________________");
        Singer singer1 = new Singer("Freddie Mercury", new String[] { "We Are the Champions", "Somebody to Love" });
        Singer singer2 = new Singer("David Bowie",new String[] { "Space Oddity", "Let Me Sleep Beside You", "Suffragette City" });
        Singer singer3 = new Singer("James Paul McCartney", new String[] { "Can’t Buy Me Love", "Another Girl" });
        Singer[] rockStars = new Singer[] { singer1, singer2, singer3 };

        List<String> song = Arrays.stream(rockStars)
                .flatMap(n-> Arrays.stream(n.getSongs()))
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(song);
    }
}
