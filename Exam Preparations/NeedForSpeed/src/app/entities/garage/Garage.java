package app.entities.garage;

import app.entities.car.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Garage {
    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new HashMap<>();
    }

    public void park(int id, Car car) {
        this.parkedCars.put(id, car);
    }

    public void unpark(int id) {
        Car remove = this.parkedCars.remove(id);
    }

    public void tune(int tuneIndex, String addOn) {
        for (Car car : parkedCars.values()) {
            car.tune(tuneIndex, addOn);
        }
    }

    public Map<Integer, Car> getParkedCars() {
        return parkedCars;
    }
}
