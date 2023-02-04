package innerClasses;

public class InnerClassesTest {
    public static void main(String[] args) {
        Letter l = new Letter("Alexander"); //Создание объекта внешнего класса
        Letter.Address addr = l.new Address(1); //Создание объекта внутреннего класса
        System.out.println("l = " + l);
        System.out.println("addr = " + addr);
        System.out.println("addr.getLetterSender() = " + addr.getLetterSender());
    }
}
