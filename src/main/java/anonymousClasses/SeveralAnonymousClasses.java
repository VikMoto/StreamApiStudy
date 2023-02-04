package anonymousClasses;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class SeveralAnonymousClasses {
    public static void main(String[] args) {

 /**
  * SeveralAnonymousClasses for static context
  * */
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Comparator<String> cmp2 = null;
        try {
            cmp2 = cmp.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(cmp2 == cmp);

        /**
         * SeveralAnonymousClasses for non-static context
         * */

        OuterAnonymous oc = new OuterAnonymous("Cat");
        Comparable<String> cmp3 = null;
        try {
            cmp3 = oc.comparable.getClass().getDeclaredConstructor(OuterAnonymous.class).newInstance(oc);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
                 InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        System.out.println(oc.comparable);
        System.out.println("cmp3 = " + cmp3);
        System.out.println(cmp3 == oc.comparable);
    }
}

class OuterAnonymous{
    private String text;
    public Comparable<String>  comparable= new Comparable<String>() {
        public int direction;

        {
            direction = 1;
        }

        @Override
        public int compareTo(@NotNull String o) {
            return (OuterAnonymous.this.text.length() - o.length()) * direction;
        }
    };

    public OuterAnonymous(String text) {
        this.text = text;
    }

    public int compareLength(String text) {
        return comparable.compareTo(text);
    }
}
