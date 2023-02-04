package anonymousClasses;

public class AnonymousAsInner {
    private String text;

    public Comparable<String> comparable = new Comparable<String>() { //public field in class UnanimusAsInner
        @Override
        public int compareTo(String o) {
            return AnonymousAsInner.this.text.compareTo(o);
        }
    };
    public AnonymousAsInner(String text) {
        super();
        this.text = text;
    }
}
