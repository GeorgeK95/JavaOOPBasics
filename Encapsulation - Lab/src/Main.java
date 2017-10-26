import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            try {
                persons.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //task_1
        /*Collections.sort(persons, (firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (sComp != 0) {
                return sComp;
            } else {
                return firstPerson.getAge().compareTo(secondPerson.getAge());
            }
        });*/

        //task_2
     /*   int bonus = Integer.parseInt(reader.readLine());
        for (Person person : persons) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }*/

        //task_1
        /*for (Person person : persons) {
            System.out.println(person.toString());
        }*/

//        task_3
        Team team = new Team("Minior");
        for (Person person : persons) {
            team.addPlayer(person);
        }
        System.out.println("First team have " + team.getFirstTeamPlayer().size() + " players");
        System.out.println("Reserve team have " + team.getReverseTeamPlayer().size() + " players");
    }

}
