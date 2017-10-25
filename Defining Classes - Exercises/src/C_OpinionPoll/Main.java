package C_OpinionPoll;


import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Set<Person> people = read();
        print(people);
    }

    private static Set<Person> read() {
        Scanner in = new Scanner(System.in);
        Set<Person> people = new TreeSet<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = in.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            if (age > 30) {
                Person person = new Person(name, age);
                people.add(person);
            }
        }
        return people;
    }

    private static void print(Set<Person> people) {
        for (Person person : people) {
            System.out.printf("%s - %d%n", person.getName(), person.getAge());
        }
    }
}
