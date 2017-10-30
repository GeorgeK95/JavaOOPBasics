package mankind;

import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            readStudent();
            System.out.println();
            readWorker();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void readWorker() throws IllegalArgumentException {
        String[] data = in.nextLine().split("\\s+");
        Human worker = new Worker(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]));
        System.out.println(worker);
    }

    private static void readStudent() throws IllegalArgumentException {
        String[] data = in.nextLine().split("\\s+");
        Human student = new Student(data[0], data[1], data[2]);
        System.out.println(student);
    }
}