package vehiclesExtension;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
abstract class Vehicle {
    private double fuel;
    private double litersPerKm;
    private double capacity;

    Vehicle(double fuel, double litersPerKm, double capacity) {
        this.setCapacity(capacity);
        this.setFuel(fuel);
        this.setLitersPerKm(litersPerKm);
    }

    private double getCapacity() {
        return capacity;
    }

    private void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    double getFuel() {
        return fuel;
    }

    void setFuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuel >= this.getCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuel = fuel;
    }

    double getLitersPerKm() {
        return litersPerKm;
    }

    void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    abstract void drive(double distance);

    abstract void refuel(double liters);
}
