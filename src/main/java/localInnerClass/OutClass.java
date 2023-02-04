package localInnerClass;

import java.util.Comparator;

public class OutClass {
        private boolean reverse;

        public OutClass() {
        }

        public OutClass(boolean reverse) {
            this.reverse = reverse;
        }
        public Comparator<String> getLengtComparator() {
            int n = 5;
            class StringLengComparator implements Comparator<String> {
                @Override
                public int compare(String o1, String o2) {
                    int direction = 1;
                    if (OutClass.this.reverse){
                        direction = -1;
                    }
//                    return (o1.length() - o2.length()) * n; // n - use only effectively final variable
//                                                            // of method
                    return (o1.length() - o2.length()) * direction;
                }
            }
            return new StringLengComparator();
        }
    }
