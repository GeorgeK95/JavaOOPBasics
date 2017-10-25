package E_SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    private static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        readCars();
        readCommands();
        print();
    }

    private static void print() {
        for (Car car : cars) {
            System.out.printf("%s %.2f %d%n", car.getModel(), car.getFuelAmount(), car.getDistanceTravelled());
        }
    }

    private static void readCommands() {
        while (true) {
            String line = in.nextLine();
            if ("End".equals(line)) {
                break;
            }
            String[] data = line.split("\\s+");
            String model = data[1];
            int dist = Integer.parseInt(data[2]);
            Car found = getCarByModel(model);
            if (found != null) {
                found.drive(dist);
            }
        }
    }

    private static Car getCarByModel(String model) {
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    private static void readCars() {
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = in.nextLine().split("\\s+");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCostPerKm = Double.parseDouble(data[2]);
            Car car = new Car(model, fuelAmount, fuelCostPerKm);
            cars.add(car);
        }
    }


}
