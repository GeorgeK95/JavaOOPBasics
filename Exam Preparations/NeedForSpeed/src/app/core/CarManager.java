package app.core;

import app.entities.car.Car;
import app.entities.garage.Garage;
import app.entities.race.Race;
import app.factories.CarFactory;
import app.factories.RaceFactory;

import java.util.HashMap;
import java.util.Map;

import static app.utilities.Constants.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CarManager {

    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        if (type.equals(PERFORMANCE_CAR_TYPE)) {
            this.cars.put(id, CarFactory.createPerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability));
        } else if (type.equals(SHOW_CAR_TYPE)) {
            this.cars.put(id, CarFactory.createShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability));
        }
    }

    public String check(int id) {
        return this.cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        switch (type) {
            case DRIFT_RACE_TYPE:
                this.races.put(id, RaceFactory.createDriftRace(length, route, prizePool));
                break;
            case DRAG_RACE_TYPE:
                this.races.put(id, RaceFactory.createDragRace(length, route, prizePool));
                break;
            case CASUAL_RACE_TYPE:
                this.races.put(id, RaceFactory.createCasualRace(length, route, prizePool));
                break;
        }
    }

    public void participate(int carId, int raceId) {
        if (!this.garage.getParkedCars().containsKey(carId)) {
            this.races.get(raceId).addParticipant(this.cars.get(carId));
        }
    }

    public String start(int id) {
        if (this.races.get(id).getParticipants().size() > 0) {
            return this.races.remove(id).toString();
        }

        return "Cannot start the race with zero participants.";
    }

    public void park(int id) {
        if (this.cars.containsKey(id) && !this.isCarInRace(id)) {
            this.garage.park(id, this.cars.get(id));
        }
    }

    private boolean isCarInRace(int carId) {
        return this.races.values().stream().filter(x -> x.getParticipants().contains(this.cars.get(carId))).count() != 0;
    }

    public void unpark(int id) {
        if (this.garage.getParkedCars().containsKey(id)) {
            this.garage.unpark(id);
        }
    }

    public void tune(int tuneIndex, String addOn) {
        this.garage.tune(tuneIndex, addOn);
    }

    public void open(int id, String type, int length, String route, int prizePool, int bonusParam) {
        switch (type) {
            case TIME_LIMIT_RACE_TYPE:
                this.races.put(id, RaceFactory.createTimeLimitRace(length, route, prizePool, bonusParam));
                break;
            case CIRCUIT_RACE_TYPE:
                this.races.put(id, RaceFactory.createCircuitRace(length, route, prizePool, bonusParam));
                break;
        }
    }
}
