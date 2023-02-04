package innerClasses;

public abstract class FunctionInner {
    public abstract int functionInner(int n);

    public  int calculate (int begin, int end) {
        System.out.println("begin = " + begin + "  end = " + end);
        int result = functionInner(end) - functionInner(begin);
        System.out.println("result = " + result);
        return  result;
    }
}
