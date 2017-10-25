package D_CompanyRoster;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
