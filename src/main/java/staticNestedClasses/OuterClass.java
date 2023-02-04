package staticNestedClasses;
/**
 * What are static nested most often used for?
 *
 * classes
 *
 * Static nested classes are often used to:
 * ● Emphasizing that one entity (Static nested classes (outer class)) consists of smaller
 * parts (Static nested classes) inner class).
 * ● Hiding part of the logic inside the class. For example, a node in a tree implementation or
 * map.
 * */
public class OuterClass {
    private String text;
    private static int number = 10;
    public OuterClass(String text) {
        super();
        this.text = text;
    }

    public class InnerClass {
        private int pages = 10;
    }
    public static class SuperNestedClass {
        private String author = "Bob";
    }
    public static class NestedClass extends InnerClass{ //declare static nested class
        private String word;
        public NestedClass(OuterClass oClass, String word) {
            oClass.super() ;
//            super();
            this.word = word;
        }


        public void printText() {
            System.out.println(word + " " + number);
        }
        public void printText(OuterClass outerClass) { //OuterClass outerClass - referance on object outer class
            System.out.println(word + " " + number + outerClass.text); //outerClass.text - get to private field
                                                                       // outer class
        }
    }
}
