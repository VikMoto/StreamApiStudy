package staticNestedClasses;

public class OuterClassTest {
    public static void main(String[] args) {
        OuterClass oc = new OuterClass("world");
        OuterClass.NestedClass on = new OuterClass.NestedClass(oc,"Hello");
        on.printText(oc);
        on.printText();
    }

}
