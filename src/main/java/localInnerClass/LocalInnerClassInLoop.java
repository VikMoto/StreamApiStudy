package localInnerClass;

public class LocalInnerClassInLoop {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            class Printer {
                private String text;
                public Printer(String text) {
                    this.text = text;
                }
                public void print() {
                    System.out.println("***" + text + "***");
                }
            }
            Printer prt = new Printer("Hello");
            prt.print();
        }
    }
}
