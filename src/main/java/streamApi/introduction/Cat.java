package streamApi.introduction;

import java.util.Objects;

public class Cat {
    private String name;
    private int weight;
    private String color;

    public Cat(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public Cat() {
    }

    public String getName() {
//        System.out.println("name = " + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Cat [name=" + name + ", weight=" + weight + ", color=" + color + "]";

    }

    /**
     * There are two equivalent objects in the list, but since the equals method in the Cat class is not
     * implemented, the default implementation of equals is used. As a result, the distinct method
     * does not remove equivalent objects from the stream. This is because the implementation of equals
     * By default, it compares not the state of objects, but the addresses of links.
     * */

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Cat)) return false;
//        Cat cat = (Cat) o;
//        return weight == cat.weight && Objects.equals(name, cat.name) && Objects.equals(color, cat.color);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, color);
    }
}

