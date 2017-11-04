package vehicles;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
abstract class Vehicle {
    private double fuel;
    private double litersPerKm;

    Vehicle(double fuel, double litersPerKm) {
        this.setFuel(fuel);
        this.setLitersPerKm(litersPerKm);
    }

     double getFuel() {
        return fuel;
    }

     void setFuel(double fuel) {
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
