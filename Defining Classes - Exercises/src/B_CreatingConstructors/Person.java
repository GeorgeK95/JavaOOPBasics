package B_CreatingConstructors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Person {
    private int age;
    private String name;

    public Person() {
        this(1);
    }

    public Person(int age) {
        this("No name", age);
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
