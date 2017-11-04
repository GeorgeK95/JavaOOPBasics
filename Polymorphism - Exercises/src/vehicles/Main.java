package vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String[] data = in.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
        data = in.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
        readCommands(car, truck);
        print(car, truck);
    }

    private static void readCommands(Car car, Truck truck) {
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = in.nextLine().split("\\s+");
            if (input[1].equals("Car")) {
                processCar(car, input);
            } else if (input[1].equals("Truck")) {
                processTruck(truck, input);
            }
        }
    }

    private static void print(Car car, Truck truck) {
        System.out.printf("Car: %.2f%n", car.getFuel());
        System.out.printf("Truck: %.2f", truck.getFuel());
    }

    private static void processTruck(Truck truck, String[] input) {
        double distance = Double.parseDouble(input[2]);
        try {
            switch (input[0]) {
                case "Drive":
                    truck.drive(distance);
                    System.out.println(String.format("Truck travelled %s km", new DecimalFormat("#.##").format(distance)));
                    break;
                case "Refuel":
                    truck.refuel(distance);
                    break;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void processCar(Car car, String[] input) {
        double distance = Double.parseDouble(input[2]);
        try {
            switch (input[0]) {
                case "Drive":
                    car.drive(distance);
                    System.out.println(String.format("Car travelled %s km", new DecimalFormat("#.##").format(distance)));
                    break;
                case "Refuel":
                    car.refuel(distance);
                    break;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
