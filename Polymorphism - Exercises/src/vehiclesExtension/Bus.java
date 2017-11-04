package vehiclesExtension;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Bus extends Vehicle {
    private static final double AC_CONSUMATION = 1.4;

    Bus(double fuel, double litersPerKm, double capacity) {
        super(fuel, litersPerKm, capacity);
    }

    @Override
    void drive(double distance) {
        double needed = (super.getLitersPerKm()) * distance;
        if (needed > super.getFuel()) {
            throw new IllegalArgumentException("Bus needs refueling");
        }
        super.setFuel(super.getFuel() - needed);
    }

    void driveEmpty(double distance) {
        super.setLitersPerKm(this.getLitersPerKm() + AC_CONSUMATION);
        this.drive(distance);
    }

    @Override
    void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        super.setFuel(super.getFuel() + liters);
    }
}
