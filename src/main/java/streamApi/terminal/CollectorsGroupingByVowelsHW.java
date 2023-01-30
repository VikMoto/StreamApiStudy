package streamApi.terminal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorsGroupingByVowelsHW {
    public static void main(String[] args) {
        Collector<String, Map<String, String>, Map<String, String>> collector = new GroupByVowel<String>();
        String text = "Creates a result brrt accumulating ttt stream elements.";
        Map<String, String> result = Arrays.stream(text.split(" "))

                .filter(a -> countVowels(a) !=0)
                .peek(System.out::print)
                .collect(collector);
        System.out.println(result);




    }

    private static int countVowels(String s) {
        return s.replaceAll("[^aieouy]", "").length();
    }
}

class GroupByVowel<S> implements Collector<String, Map<String,String>, Map<String,String>> {

    @Override
    public Supplier<Map<String, String>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, String>, String> accumulator() {
        return (map, s) -> {
            System.out.println("s = " + s);
            map.put(s, s);
            System.out.println("map = " + map);
        };
    }

    @Override
    public BinaryOperator<Map<String, String>> combiner() {
        return (map, map2) -> {
          Map<String, String> result = new HashMap<>(map);
          map2.forEach( (k, v) -> {
              System.out.println(k + "---" + v);
//            String str = result.getOrDefault(k, "");
            result.put(k, v);
          });
          return result;
        };
    }

    @Override
    public Function<Map<String, String>, Map<String, String>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED);
    }
}



