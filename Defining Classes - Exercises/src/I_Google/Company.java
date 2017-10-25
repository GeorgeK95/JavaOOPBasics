package I_Google;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Company {
    private String name;
    private String department;
    private double salary;

    Company(String name, String department, double salary) {
        this.setName(name);
        this.setDepartment(department);
        this.setSalary(salary);
    }

    @Override
    public String toString() {
        String format = String.format("%s %s %.2f", this.getName(), this.getDepartment(), this.getSalary());
        return format;
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getDepartment() {
        return department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    private double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }
}
