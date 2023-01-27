package streamApi.introduction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class StreamFromFile {
    public static void main(String[] args) {
        try {
            Optional<String> max = Files.lines(Path.of("name.txt"))
                    .max((a, b) -> a.length() - b.length());
            System.out.println("max.get() = " + max.get());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
