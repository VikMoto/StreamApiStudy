package anonymousClasses;

public class Cat {
   private String name;

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }

    public String getVoice() {
        return "Meow";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
