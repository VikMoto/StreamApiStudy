package anonymousClasses;

public class DeclaringAdditionalMembersAnonymousClasses {
    private String text;
    public Comparable<String> cmp = new Comparable<String>() {
//        public int direction = 1;
        public int direction;
        {
            direction = 1;
        } //non static initialization
        // partial solve problem absent constructor


        public int compareTo(String o) {
            return (DeclaringAdditionalMembersAnonymousClasses.this.text.length() - o.length())
                    * direction;
        }
    };
    public DeclaringAdditionalMembersAnonymousClasses(String text) {
        this.text = text;
    }
    public int compareLength(String text) {
//        int temp = cmp.direction; //error compilation - from outer field unacsessable
        return cmp.compareTo(text);
    }
}
