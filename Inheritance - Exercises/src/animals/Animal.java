package animals;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Animal {
    private String name;
    private int age;
    private String gender;

    Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setMale(gender);
    }

    Animal() {

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + System.getProperty("line.separator") + String.format("%s %d %s", this.name, this.age, this.gender);
    }

    void produceSound() {
        System.out.println("Not implemented!");
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private String getMale() {
        return gender;
    }

    private void setMale(String male) {
        if (male == null || (!male.equals("Female") && !male.equals("Male"))) {
            throw new IllegalArgumentException("Invalid input!");
        }
        gender = male;
    }
}
