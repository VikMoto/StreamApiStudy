package streamApi.Intermediate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Based on the directory address, select a list of files with a "pdf" extension.
 *
 * */
public class FileTaskHW {
    public static void main(String[] args) throws IOException {
        // определяем объект для каталога
        File dir = new File("d:\\redmi 7 06052022\\DCIM\\Camera");
        // если объект представляет каталог
//        if(dir.isDirectory())
//        {
//            // получаем все вложенные объекты в каталоге
//            for(File item : dir.listFiles()){
//
//                if(item.isDirectory()){
//
//                    System.out.println(item.getName() + "  \t folder");
//                }
//                else{
//
//                    System.out.println(item.getName() + " " + "\t file");
//                }
//            }
//        }

        final List<Path> pdf = Files.list(Path.of("d:\\redmi 7 06052022\\Documents"))
//                .map(a -> a.getFileName().toString())
//                .filter(a -> a.endsWith("pdf"))
//                .map(a -> Paths.get(a))
                .collect(Collectors.toList());


//        System.out.println("pdf = " + pdf);

        Path path = pdf.get(0);
            System.out.format("toString: %s%n", path.toString());
            System.out.format("getFileName: %s%n", path.getFileName());
            System.out.format("getName(0): %s%n", path.getName(0));
            System.out.format("getNameCount: %d%n", path.getNameCount());
            System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
            System.out.format("getParent: %s%n", path.getParent());
            System.out.format("getRoot: %s%n", path.getRoot());

    }
}
