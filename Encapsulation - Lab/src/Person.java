/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    void increaseSalary(int bonus) {
        int divisor = 100;
        if (this.getAge() < 30) {
            divisor *= 2;
        }
        this.salary += this.salary * bonus / divisor;
    }

    double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    Integer getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    @Override
    public String toString() {
//        return String.format("%s %s is %d years old.", this.getFirstName(), this.getLastName(), this.getAge()); //task_1
        return String.format("%s %s gets %s leva", this.getFirstName(), this.getLastName(), this.getSalary()); //task_2
    }
}
