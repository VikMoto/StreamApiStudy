package streamApi.introduction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileStudy {
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

//        List<Path> collect = Files.list(Path.of("d:\\redmi 7 06052022\\DCIM\\Camera"))
//                .filter(a -> a.)
//                .collect(Collectors.toList());

//        collect.stream()
//        System.out.println("collect = " + collect);

    }
}
