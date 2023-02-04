package innerClasses.InheritanceInnerClass;

public class InnerSubClass extends OuterInheritance.Inner {
    public InnerSubClass(OuterInheritance outer) { //OuterInheritance outer - referance on object outer class
        outer.super(" Hello "); //super - run constructor of superclass inner class

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
    }
}
