package streamApi.terminal;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileClassifierCollectorsGroupingBy {
    public static void main(String[] args) {
        // classifier - gets extension of each file and use as key of Map
        Function<File, String> classifier = a ->
           a.getName().substring(a.getName().lastIndexOf(".") + 1);//return substring from "."
                                                                                // and to end of string - name of file

        Map<String, List<File>> groupByExt = Arrays.stream(new File("sample_folder").listFiles())
                .collect(Collectors.groupingBy(classifier));
        System.out.println("groupByExt = " + groupByExt);

/**
 * groupByExt = {
 * jpg=[sample_folder\200120100899_177668.jpg],
 * txt=[sample_folder\Январь-2023.txt],
 * pdf=[sample_folder\ISO_29119_4_Software_testing_Test_techniques_preview_2021.pdf,
 * sample_folder\Manning.AWS.pdf],
 * png=[sample_folder\2022-10-20_140211.png,
 * sample_folder\image_2022-12-23_21-03-15.png]
 * }
 */

        Map<String, List<String>> fileType = Map.of("document", List.of("txt", "docx", "odt", "pdf"),
                "image", List.of("jpg", "png"));

        Function<File, String> getFileExc = a -> {
            int n = a.getName().lastIndexOf(".");
            if (n == -1) {
                return "";
            }
            return a.getName().substring(n + 1); //if found return substring from "." and to end of string - name of file
        };

        Function<File, String> outerClassifier = file -> {
            for (String type : fileType.keySet()) { // for each key of Map - fileType
                String ext = getFileExc.apply(file);// get extension of file
                if (fileType.get(type).contains(ext)) { //if got extension contains in List particular key
                    return type;                        // return name of this particular key
                                                      // for example "document" or "image"
                }
            }
            return "not classified";
        };
        Function<File, String> innerClassifier = a -> getFileExc.apply(a);

        Map<String, Map<String, List<File>>> groupByExt2 = Arrays.stream(new File("sample_folder").listFiles())
                .collect(Collectors.groupingBy(outerClassifier, Collectors.groupingBy(innerClassifier)));

        groupByExt2.forEach((type, typeMap) -> {
            System.out.println(type);
            typeMap.forEach((ext, files) -> {
                System.out.println("\t" + ext);
                files.forEach(a -> System.out.println("\t\t" + a));
            });
        });

    }
}
