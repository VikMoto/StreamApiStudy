package streamApi.terminal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetFileSize {

    public static void main(String[] args) {


/**
 * Implement a file classifier based on file size.
 *
 * */

        Map<String, List<Long>> fileSize = Map.of("Large", List.of(100_000_000L),
                "Medium", List.of(10_000_000L, 99_000_000L), "Small" , List.of (9_000_000L) );

        Function<File, Long> getFileSize = a -> {
            // size of a file (in bytes)
            return a.length(); //
        };

        Function<File, String> outerClassifier = file -> {
                Long size = getFileSize.apply(file);// get size of file
                if (size >= 100_000_000L  )  {
                    return "Large";
                }
                if (size >= 10_000_000L && size < 100_000_000L )  {
                    return "Medium";
                }
                if (size < 10_000_000L  )  {
                    return "Small";
                }
            return "not classified";
        };

//        Map<String, List<File>> sample_folder = Arrays.stream(new File("sample_folder").listFiles())
        Map<String, List<File>> sample_folder = Arrays.stream(new File("d:\\Video_Out").listFiles())
                .collect(Collectors.groupingBy(outerClassifier));


        sample_folder.forEach( (size, files) -> {
            System.out.println("size = " + size);
            files.forEach( a -> {
                System.out.println("\t " + a + " - " + a.length()/1024 + " kB");
            });
        });

/**
 * size = Small
 * 	 sample_folder\200120100899_177668.jpg - 142 kB
 * 	 sample_folder\2022-10-20_140211.png - 40 kB
 * 	 sample_folder\image_2022-12-23_21-03-15.png - 102 kB
 * 	 sample_folder\ISO_29119_4_Software_testing_Test_techniques_preview_2021.pdf - 1021 kB
 * 	 sample_folder\Январь-2023.txt - 57 kB
 * size = Medium
 * 	 sample_folder\Manning.AWS.pdf - 10667 kB
 *
 * */

    }

    public static void printFileSizeNIO(String fileName) {

        Path path = Paths.get(fileName);

        try {

            // size of a file (in bytes)
            long bytes = Files.size(path);
            System.out.println(String.format("%,d bytes", bytes));
            System.out.println(String.format("%,d kilobytes", bytes / 1024));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

