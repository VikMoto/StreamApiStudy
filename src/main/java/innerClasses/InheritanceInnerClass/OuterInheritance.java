package innerClasses.InheritanceInnerClass;

public class OuterInheritance {
    private int id;
    public OuterInheritance(int id) {
        this.id = id;
    }
    public OuterInheritance() {
    }
    public class Inner { //define inner class
        private String text;

        public Inner(String text) {
            this.text = text;
        }

        /**
         * When inheriting from inner classes, it is necessary in the subclass constructor
         * pass a reference to an object of the outer class (inner classes) in the Outer outer example). And using this
         * link, call the constructor of the inner class (inner classes) in the example outer.super("Hello") is
         * constructor call:
         * public Inner(String text) {
         * super();
         * this.text = text;
         * }
         *
         * */
        public String getTotalInfo() {
            return text + " " + id;
        }
    }
}