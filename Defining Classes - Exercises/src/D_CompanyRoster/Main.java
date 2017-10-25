package D_CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Map<String, List<Employee>> departmentEmployees = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = in.nextLine().split("\\s+");
            writeData(data);
        }
        print();
    }

    private static void print() {
        Comparator<? super Map.Entry<String, List<Employee>>> comp = (Comparator<Map.Entry<String, List<Employee>>>) (o1, o2) -> {
            double sal_1 = o1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            double sal_2 = o2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            return Double.compare(sal_2, sal_1);
        };
        Comparator<? super Employee> comp2 = (Comparator<Employee>) (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary());

        Optional<Map.Entry<String, List<Employee>>> first = departmentEmployees.entrySet()
                .stream()
                .sorted(comp)
                .findFirst();
        String department = first.get().getKey();
        System.out.printf("Highest Average Salary: %s%n", department);
        List<Employee> collect = first.get().getValue().stream().sorted(comp2).collect(Collectors.toList());
        for (Employee employee : collect) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }

    private static void writeData(String[] data) {
        String name = data[0];
        double salary = Double.parseDouble(data[1]);
        String position = data[2];
        String department = data[3];
        String email = "n/a";
        int age = -1;

        switch (data.length) {
            case 5:
                try {
                    age = Integer.parseInt(data[4]);
                } catch (NumberFormatException e) {
                    email = data[4];
                }
                break;
            case 6:
                email = data[4];
                age = Integer.parseInt(data[5]);
                break;
        }

        Employee employee = new Employee(name, salary, position, department, email, age);
        departmentEmployees.putIfAbsent(department, new ArrayList<>());
        List<Employee> employees = departmentEmployees.get(department);
        employees.add(employee);
        departmentEmployees.put(department, employees);
    }

}
