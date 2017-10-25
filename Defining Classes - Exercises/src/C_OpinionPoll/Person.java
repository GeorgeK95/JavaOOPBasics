package C_OpinionPoll;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 30) {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
