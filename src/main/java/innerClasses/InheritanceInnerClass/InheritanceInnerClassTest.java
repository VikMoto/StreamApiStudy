package innerClasses.InheritanceInnerClass;

public class InheritanceInnerClassTest {
    public static void main(String[] args) {
        OuterInheritance outer = new OuterInheritance(11);
        InnerSubClass ins = new InnerSubClass(outer);
        System.out.println("ins = " + ins.getTotalInfo());
    }

}
