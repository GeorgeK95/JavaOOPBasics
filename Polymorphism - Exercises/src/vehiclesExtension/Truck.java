package vehiclesExtension;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Truck extends Vehicle {
    private static final double AC_CONSUMATION = 1.6;
    private static final double FUEL_PERCENTAGE = 0.95;

    Truck(double fuel, double litersPerKm, double capacity) {
        super(fuel, litersPerKm + AC_CONSUMATION, capacity);
    }

    @Override
    void drive(double distance) {
        double needed = (super.getLitersPerKm()) * distance;
        if (needed > super.getFuel()) {
            throw new IllegalArgumentException("Truck needs refueling");
        }
        super.setFuel(super.getFuel() - needed);
    }

    @Override
    void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        super.setFuel(super.getFuel() + liters * FUEL_PERCENTAGE);
    }
}
