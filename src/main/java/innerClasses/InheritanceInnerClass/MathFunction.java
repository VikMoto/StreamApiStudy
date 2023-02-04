package innerClasses.InheritanceInnerClass;

import innerClasses.FunctionInner;

public class MathFunction {
    private class Square extends FunctionInner {
        @Override
        public int functionInner(int n) {
            System.out.println("nSquare = " + n);
            return n * n;
        }
    }
    private class Cube extends FunctionInner {
        @Override
        public int functionInner(int n) {
            System.out.println("nCube = " + n);
            return n * n * n;
        }
    }

    public FunctionInner getSquare() {
        return new Square();
    }

    public FunctionInner getCube() {
        return new Cube();
    }
}
