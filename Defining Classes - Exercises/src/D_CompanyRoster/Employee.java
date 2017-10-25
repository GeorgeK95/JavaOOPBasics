package D_CompanyRoster;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Employee extends Person {
    private double salary;
    private String position;
    private String department;
    private String email;


    public Employee(String name, int age) {
        super(name, age);
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, age);
        this.setSalary(salary);
        this.setPosition(position);
        this.setDepartment(department);
        this.setEmail(email);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            this.email = "n/a";
        } else {
            this.email = email;
        }
    }
}
