package animalProject;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Chicken {
    private String name;
    private int age;

    Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.0f eggs per day.", this.getName(), this.getAge(), this.calculateProductPerDay(this.getAge()));
    }

    private double calculateProductPerDay(int age) {
        if (age < 6) {
            return 2;
        }
        if (age < 12) {
            return 1;
        }
        return 0.75;
    }

}
