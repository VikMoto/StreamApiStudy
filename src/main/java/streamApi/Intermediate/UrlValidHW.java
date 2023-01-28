package streamApi.Intermediate;

import org.apache.commons.validator.routines.UrlValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UrlValidHW {

/**************************************************************************************************
 * Create a text file with url addresses. Using the Stream API, extract only those addresses
 * which are currently available.
 * ************************************************************************************************
 * */

        public static boolean urlValidator(String url)
        {
            // Получить `UrlValidator`, используя схемы по умолчанию
            UrlValidator defaultValidator = new UrlValidator();
            return defaultValidator.isValid(url);
        }

        public static void main(String[] args)
        {
            try {

/**listXml = [<project xmlns="http://maven.apache.org/POM/4.0.0",
 *  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance",
 *  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
 *  http://maven.apache.org/xsd/maven-4.0.0.xsd">,
 *  <!-- https://mvnrepository.com/artifact/org.apache.maven/maven-core -->,
 *  <!-- https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple -->,
 *  <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->,
 *  <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->,
 *  <!-- https://mvnrepository.com/artifact/commons-validator/commons-validator -->,
 *  <!-- jsoup HTML parser library @ https://jsoup.org/ -->,
 *  <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->]
 * */

                List<String> listHttp = Files.lines(Path.of("httptest.txt"))
                        .map(a -> a.split(","))
                        .flatMap(a -> Stream.of(a))
                        .filter( a -> a.length() > 0)
                        .map( a -> a.trim())
                         .collect(Collectors.toList());
                System.out.println("listHttp = " + listHttp);
                System.out.println();

                List<String> listHttp2 = Files.lines(Path.of("httptest.txt"))
                    .map(a -> a.split(","))
                    .flatMap(a -> Stream.of(a))
//                    .filter( a -> a.length() > 0)
                    .map( a -> a.trim())
                        .filter( a -> urlValidator(a))
//                    .map(a -> a.replaceAll("[^\\w+]",""))
                    .collect(Collectors.toList());

                System.out.println("listHttp2 = " + listHttp2);
                System.out.println();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


            String url = "https://www.techiedelight.com/";

            // Проверка URL-адреса
            if (urlValidator(url)) {
                System.out.print("The url " + url + " is valid");
            }
            else {
                System.out.print("The url " + url + " isn't valid");
            }
        }




}
