package streamApi.Intermediate;

import streamApi.introduction.Cat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFromFileHW2 {
    public static void main(String[] args) {

/**********************************************************************************
 * Put these strings in a string array, create a stream based on it and extract the
 * values in the <groupid> tag and
 * collect the result into a list of strings.
 **********************************************************************************
 *  */
//        try {
//
//            List<String> listXml = Files.lines(Path.of("pom.xml"))
//                    .filter( a -> a.contains("http"))
//                    .map( a -> a.trim())
//                    .collect(Collectors.toList());
//            System.out.println("listXml = " + listXml);
//            System.out.println();
//
//            List<String> listXml1 = Files.lines(Path.of("pom.xml"))
//                    .filter( a -> a.contains("<groupId>"))
//                    .map( a -> a.trim())
//                    .collect(Collectors.toList());
//            System.out.println("listXml = " + listXml1);
//            System.out.println();
//
//            List<String> listXml2 = Files.lines(Path.of("pom.xml"))
//                    .filter( a -> a.contains("<groupId>"))
//                    .map( a -> a.replaceAll("<groupId>",""))
//                    .map( a -> a.replaceAll("</groupId>",""))
//                    .map( a -> a.trim())
//                    .collect(Collectors.toList());
//
//            System.out.println("listXml = " + listXml2);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
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

//____________________________________________________________________________________
/**
 *****************************************************************************
 * Remove all words longer than 5 characters from a line of text.
 *****************************************************************************
 */


        try {

            final List<String> stringList = Files.lines(Path.of("test.txt"))
                    .flatMap(a -> Stream.of(a.split(" ")))
                    .collect(Collectors.toList());
            System.out.println("stringList = " + stringList);
            System.out.println();

            List<String> stringList2 = Files.lines(Path.of("test.txt"))
                    .flatMap(a -> Stream.of(a.split(" ")))
                    .filter(a -> a.length() <= 5)
/**
 * The following code replaces all matches of the regular expression \w with the
 * empty string "". Note that \w is a predefined character class that stands for
 * the word character [a-zA-Z_0-9].
 * For example, [^a-zA-Z] matches any character except a to z and A to Z.
 */
                    .map(a -> a.replaceAll("[^\\w+]",""))
                    .filter( a -> a.length() > 0)
                    .collect(Collectors.toList());

            System.out.println("stringList = " + stringList2);
            System.out.println();
//
//            List<String> listXml5 = Files.lines(Path.of("test.txt"))
//                    .filter( a -> a.contains("<groupId>"))
//                    .map( a -> a.replaceAll("<groupId>",""))
//                    .map( a -> a.replaceAll("</groupId>",""))
//                    .map( a -> a.trim())
//                    .collect(Collectors.toList());

//            System.out.println("listXml = " + listXml5);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
/**
 *****************************************************************************
 * Remove from the List<Cat> all cats whose weight is less than 3 kg, sort them by
 * name (in lexicographical order) and assemble the result into a new list Cat.
 *****************************************************************************
 */

        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("UmkA", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Kuzia", 3, "Grey");
        Cat cat5 = new Cat("Hug", 1, "Black");
        Cat cat6 = new Cat("Barsic", 2, "Red");
        Cat cat7 = new Cat("Barsic", 6, "RedWhite");

        List<Cat> cats = List.of(cat1,cat2,cat3,cat4, cat5, cat6, cat7);
        System.out.println("cats = " + cats);

        List<Cat> catsFilter = cats.stream()
                .filter(a -> a.getWeight() >= 3)
                .collect(Collectors.toList());

        System.out.println("catsFilter = " + catsFilter);


    }
}
