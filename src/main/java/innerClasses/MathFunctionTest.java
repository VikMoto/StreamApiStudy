package innerClasses;

import innerClasses.InheritanceInnerClass.MathFunction;

public class MathFunctionTest {
    public static void main(String[] args) {
        MathFunction mathFunction = new MathFunction();
        System.out.println("calculate(mathFunction.getSquare(), 1, 4) = " + calculate(mathFunction.getSquare(), 1, 4));//get one realization
        System.out.println("calculate(mathFunction.getCube(), 1, 4) = " + calculate(mathFunction.getCube(), 1, 4));//get second realization
    }
    //FunctionInner fun - use reference type of abstract class
    public static int calculate(FunctionInner fun, int begin, int end) {
        return fun.calculate(begin, end);
    }
}
