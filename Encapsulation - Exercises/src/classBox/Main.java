package classBox;

import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double length = Double.parseDouble(in.nextLine());
        double width = Double.parseDouble(in.nextLine());
        double height = Double.parseDouble(in.nextLine());

        try {
            Box box = new Box(length, width, height);
            System.out.println(box);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
