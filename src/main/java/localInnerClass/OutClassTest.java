package localInnerClass;

public class OutClassTest {
    public static void main(String[] args) {
        OutClass oc = new OutClass();
        System.out.println(oc.getLengtComparator().compare("Cat", "Lion"));
    }
}
