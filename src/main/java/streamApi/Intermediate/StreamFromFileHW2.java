package streamApi.Intermediate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamFromFileHW2 {
    public static void main(String[] args) {

/**
 * Put these strings in a string array, create a stream based on it and extract the values in the <groupid> tag and
 * collect the result into a list of strings.
 * */
        try {

            List<String> listXml = Files.lines(Path.of("pom.xml"))
                    .filter( a -> a.contains("http"))
                    .map( a -> a.trim())
                    .collect(Collectors.toList());
            System.out.println("listXml = " + listXml);
            System.out.println();

            List<String> listXml1 = Files.lines(Path.of("pom.xml"))
                    .filter( a -> a.contains("<groupId>"))
                    .map( a -> a.trim())
                    .collect(Collectors.toList());
            System.out.println("listXml = " + listXml1);
            System.out.println();

            List<String> listXml2 = Files.lines(Path.of("pom.xml"))
                    .filter( a -> a.contains("<groupId>"))
                    .map( a -> a.replaceAll("<groupId>",""))
                    .map( a -> a.replaceAll("</groupId>",""))
                    .map( a -> a.trim())
                    .collect(Collectors.toList());

            System.out.println("listXml = " + listXml2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
/**
 * listXml = [<groupId>streamApi</groupId>, <groupId>org.apache.maven</groupId>,
 * <groupId>org.testng</groupId>, <groupId>junit</groupId>,
 * <groupId>com.googlecode.json-simple</groupId>, <groupId>com.google.code.gson</groupId>,
 * <groupId>com.fasterxml.jackson.core</groupId>, <groupId>org.jsoup</groupId>,
 * <groupId>org.projectlombok</groupId>, <groupId>org.jetbrains</groupId>]
 *
 * listXml = [streamApi, org.apache.maven, org.testng, junit, com.googlecode.json-simple,
 * com.google.code.gson, com.fasterxml.jackson.core, org.jsoup, org.projectlombok,
 * org.jetbrains]
 * */
    }
}
