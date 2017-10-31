package mordorsCrueltyPlan;

import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] food = in.nextLine().split("\\s+");
        Wizard gandalf = new Wizard();
        gandalf.eatAll(food);
        System.out.println(gandalf.getPoints());
        System.out.println(gandalf);
    }
}
