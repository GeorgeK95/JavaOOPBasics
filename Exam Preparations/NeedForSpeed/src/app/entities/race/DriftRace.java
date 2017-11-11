package app.entities.race;

import app.entities.car.Car;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class DriftRace extends Race {

    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int calculatePerformancePoints(Car car) {
        return car.getSuspension() + car.getDurability();
    }
}
