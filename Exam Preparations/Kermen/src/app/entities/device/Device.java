package app.entities.device;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Device {
    private double electricCost;

    public Device(double electricCost) {
        this.setElectricCost(electricCost);
    }

    public double getElectricCost() {
        return electricCost;
    }

    private void setElectricCost(double electricCost) {
        this.electricCost = electricCost;
    }
}
