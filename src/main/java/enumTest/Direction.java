package enumTest;

public enum Direction {
    UP { //realize abstract method by realizing abstract class
        @Override
        public int changeCoordinate() { //realize abstract method
            return 1;
        }
    },
    DOWN {
        @Override
        public int changeCoordinate() {
            return -1;
        }
    };

public abstract int changeCoordinate(); //define abstract method


}
