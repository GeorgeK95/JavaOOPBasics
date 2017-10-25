package F_RawData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static List<Car> cars = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        readData();
        print();
    }

    private static void print() {
        String line = in.nextLine();
        switch (line) {
            case "fragile":
                printFragile();
                break;
            case "flamable":
                printFlamable();
                break;
        }
    }

    private static void printFlamable() {
        Predicate<Car> typePredicate = x -> x.getCargo().getCargoType().equals("flamable");
        Predicate<Car> enginePowerPredicate = x -> x.getEngine().getEnginePower() > 250;
        List<Car> carList = cars.stream().filter(typePredicate).filter(enginePowerPredicate).collect(Collectors.toList());
        for (Car car : carList) {
            System.out.printf("%s%n", car.getModel());
        }
    }

    private static void printFragile() {
        Predicate<Car> typePredicate = x -> x.getCargo().getCargoType().equals("fragile");
        Predicate<Car> tirePredicate = x -> Arrays.stream(x.getTires()).anyMatch(y -> y.getPressure() < 1);
        List<Car> carList = cars.stream().filter(typePredicate).filter(tirePredicate).collect(Collectors.toList());
        for (Car car : carList) {
            System.out.printf("%s%n", car.getModel());
        }
    }

    private static void readData() {
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = in.nextLine().split("\\s+");
            String model = data[0];
            Engine engine = new Engine(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            Cargo cargo = new Cargo(data[4], Integer.parseInt(data[3]));
            Tire[] tires = readTires(Arrays.copyOfRange(data, 5, 13));
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }
    }

    private static Tire[] readTires(String[] strings) {
        Tire[] tires = new Tire[4];
        int c = 0;
        for (int i = 0; i < strings.length; i += 2) {
            double pressure = Double.parseDouble(strings[i]);
            int age = Integer.parseInt(strings[i + 1]);
            Tire tire = new Tire(pressure, age);
            tires[c] = tire;
            c++;
        }
        return tires;
    }
}
