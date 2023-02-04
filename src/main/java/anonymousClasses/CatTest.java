package anonymousClasses;

import java.util.Arrays;
import java.util.Comparator;

public class CatTest {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska");
        System.out.println("cat1 = " + cat1);
        System.out.println("cat1.getVoice() = " + cat1.getVoice());

        Cat cat2 = new Cat() {//declare unanimous class
            @Override
            public String getVoice() {
                return "woof";
            }
        };
        System.out.println("cat2 = " + cat2);
        System.out.println("cat2.getVoice() = " + cat2.getVoice());
        System.out.println("cat2.getClass().getName() = " + cat2.getClass().getName());

        //name of anonymous class - anonymousClasses.CatTest$1
        //DeclaringAdditionalMembersAnonymousClasses
/**         --------------------------------------------------------------
 *
 * realization interface Comparator
 * */

        String[] words = new String[] { "Hello", "Cat", "Home", "Student" };

        Comparator<String> cmp = new Comparator<String>() { //declare unanimous class
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }; // ; set after  unanimous class

        Arrays.sort(words, cmp); //usage unanimous class
        System.out.println(Arrays.toString(words));

        System.out.println("cmp.getClass().getName() = " + cmp.getClass().getName());
        //name of anonymous class - anonymousClasses.CatTest$2
    }
}
