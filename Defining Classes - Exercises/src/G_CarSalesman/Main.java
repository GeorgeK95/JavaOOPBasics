package G_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    private static List<Engine> engines = new ArrayList<>();
    private static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        readEngines();
        readCars();
        print();
    }

    private static void print() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static void readCars() {
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = in.nextLine().split("\\s+");
            String model = data[0];
            Engine engine = getEngineByModel(data[1]);
            String weight = "n/a";
            String color = "n/a";

            switch (data.length) {
                case 3:
                    try {
                        int weightInt = Integer.parseInt(data[2]);
                        weight = data[2];
                    } catch (NumberFormatException e) {
                        color = data[2];
                    }
                    break;
                case 4: {
                    weight = data[2];
                    color = data[3];
                    break;
                }
            }

            Car car = new Car(model, engine, weight, color);
            cars.add(car);
        }
    }

    private static Engine getEngineByModel(String model) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(model)) {
                return engine;
            }
        }
        return null;
    }

    private static void readEngines() {
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = in.nextLine().split("\\s+");
            String model = data[0];
            int power = Integer.parseInt(data[1]);
            String displacements = "n/a";
            String efficiency = "n/a";

            switch (data.length) {
                case 3:
                    try {
                        int displacementsInt = Integer.parseInt(data[2]);
                        displacements = data[2];
                    } catch (NumberFormatException e) {
                        efficiency = data[2];
                    }
                    break;
                case 4:
                    displacements = data[2];
                    efficiency = data[3];
                    break;
            }

            Engine engine = new Engine(model, power, displacements, efficiency);
            engines.add(engine);
        }
    }

}
