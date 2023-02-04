package anonymousClasses;

public class AnonymousAsInnerTest {
    public static void main(String[] args) {
        AnonymousAsInner unanimus = new AnonymousAsInner("Cat");
        System.out.println("unanimus.comparable.compareTo(\"Hello\") = " + unanimus.comparable.compareTo("Hello"));
    }
}
