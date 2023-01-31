package streamApi.terminal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;

public class ForEachTest {
    public static void main(String[] args) {
/**
 * void forEach(Consumer<? super T> action)
 * Performs an implementation-defined Consumer action on each element of the stream.
 * The order of execution is not guaranteed. Thus, the order of elements in a stream may or may not
 * be respected. Takes advantage of parallel threads.
 * */

        List<String> language = List.of("Java", "Fortran", "Python");
        language.stream().forEach(a -> System.out.println(a));

/****************************************************************************/

        List<String> message = List.of("start service", "runnable", "shutdown");
        File file = new File("message.txt");
        message.stream().forEach(getFileLogger(file));

    }
/**   method return Consumer!!! for using in foreach  */
    public static Consumer<String> getFileLogger(File file) {
        class FileLogger implements Consumer<String> {
            private File file;
            public FileLogger(File file) {
                super();
                this.file = file;
            }
            @Override
            public void accept(String t) {
                //public class FileWriter extends OutputStreamWriter
                //PrintWriter(OutputStream out): uses an existing OutputStream object
                // to print information, automatically flushing data into it
                try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
                    pw.println(t);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //return realization Consumer which write to file
        // message as put as parameter
        return new FileLogger(file);

    }
}
