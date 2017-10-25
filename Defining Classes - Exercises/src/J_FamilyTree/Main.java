package J_FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    private static List<Person> people = new ArrayList<>();
    private static List<String> data = new ArrayList<>();

    public static void main(String[] args) {
        String firstPerson = in.nextLine();
        readData();
        print(firstPerson);
    }

    private static void print(String firstPerson) {
        Person found = people.stream().filter(x -> x.getName().equals(firstPerson) || x.getDate().equals(firstPerson)).findFirst().get();
        System.out.println(found);
    }

    private static void readData() {
        while (true) {
            String line = in.nextLine();
            if ("End".equals(line)) {
                writeData();
                break;
            }
            if (line.contains(" - ")) {
                data.add(line);
            } else {
                addToPeople(line);
            }
        }
    }

    private static void addToPeople(String line) {
        String[] personInfo = line.split(" ");
        String name = personInfo[0] + " " + personInfo[1];
        String birthDate = personInfo[2];
        Person person = new Person(name, birthDate);
        people.add(person);
    }

    private static void writeData() {
        String pattern = "((?:.*) (?:.*)|(?:\\d+)\\/(?:\\d+)\\/(?:\\d{4})) - ((?:.*) (?:.*)|(?:\\d+)\\/(?:\\d+)\\/(?:\\d{4}))";
        for (String current : data) {
            Matcher m = Pattern.compile(pattern).matcher(current);
            if (m.find()) {
                String parentData = m.group(1);
                String childData = m.group(2);

                Person parent = people.stream().filter(x -> x.getName().equals(parentData) || x.getDate().equals(parentData)).findFirst().get();
                Person children = people.stream().filter(x -> x.getName().equals(childData) || x.getDate().equals(childData)).findFirst().get();

                parent.getChildren().add(children);
                children.getParents().add(parent);
            }
        }
    }
}
