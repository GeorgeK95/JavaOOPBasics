package app.factories;

import app.entities.car.PerformanceCar;
import app.entities.car.ShowCar;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class CarFactory {
    public static PerformanceCar createPerformanceCar( String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    public static ShowCar createShowCar( String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }
}
