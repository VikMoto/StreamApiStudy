package innerClasses;

public class StringWrapperTest {
    public static void main(String[] args) {
        StringWrapperIterate sw = new StringWrapperIterate("Hello");

        for (Character c : sw) {
            System.out.println(c);
            for (Character d : sw) {
                System.out.print(d);
            }
            System.out.println();
        }
    }
}
