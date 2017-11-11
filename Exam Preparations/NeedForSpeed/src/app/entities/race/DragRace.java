package app.entities.race;

import app.entities.car.Car;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class DragRace extends Race {

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int calculatePerformancePoints(Car car) {
        return car.getHorsepower() / car.getAcceleration();
    }
}
