package E_SpeedRacing;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTravelled = 0;

    Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.setModel(model);
        this.setFuelAmount(fuelAmount);
        this.setFuelCostPerKm(fuelCostPerKm);
    }

    void drive(double distance) {
        double neededFuel = fuelCostPerKm * distance;
        if (neededFuel <= fuelAmount) {
            this.fuelAmount -= neededFuel;
            this.distanceTravelled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    double getFuelAmount() {
        return fuelAmount;
    }

    private void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    private void setFuelCostPerKm(double fuelCostPerKm) {
        this.fuelCostPerKm = fuelCostPerKm;
    }

    int getDistanceTravelled() {
        return distanceTravelled;
    }

    private void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }
}
