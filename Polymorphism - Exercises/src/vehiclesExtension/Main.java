package vehiclesExtension;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String[] data = in.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
        data = in.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
        data = in.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
        readCommands(car, truck, bus);
        print(car, truck, bus);
    }

    private static void readCommands(Car car, Truck truck, Bus bus) {
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = in.nextLine().split("\\s+");
            if (input[1].equals("Car")) {
                processCar(car, input);
            } else if (input[1].equals("Truck")) {
                processTruck(truck, input);
            } else if (input[1].equals("Bus")) {
                processBus(bus, input);
            }
        }
    }

    private static void processBus(Bus bus, String[] input) {
        double distance = Double.parseDouble(input[2]);
        try {
            switch (input[0]) {
                case "Drive":
                    bus.driveEmpty(distance);
                    System.out.println(String.format("Bus travelled %s km", new DecimalFormat("#.##").format(distance)));
                    break;
                case "DriveEmpty":
                    bus.drive(distance);
                    System.out.println(String.format("Bus travelled %s km", new DecimalFormat("#.##").format(distance)));
                    break;
                case "Refuel":
                    bus.refuel(distance);
                    break;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void print(Car car, Truck truck, Bus bus) {
        System.out.printf("Car: %.2f%n", car.getFuel());
        System.out.printf("Truck: %.2f%n", truck.getFuel());
        System.out.printf("Bus: %.2f%n", bus.getFuel());
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
