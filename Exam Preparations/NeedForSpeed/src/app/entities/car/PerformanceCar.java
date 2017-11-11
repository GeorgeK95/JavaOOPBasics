package app.entities.car;

import java.util.ArrayList;
import java.util.List;

import static app.utilities.Constants.HOURSE_POWER_INCREASE_PERCENTAGE;
import static app.utilities.Constants.SUSPENSION_INCREASE_PERCENTAGE;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        super.tune(tuneIndex, addOn);
        this.addOns.add(addOn);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(String.format("Add-ons: %s",  this.addOns.size() != 0 ? String.join(", ", this.addOns) : "None"));
        return builder.toString();
    }

    @Override
    public void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower + ((horsepower * HOURSE_POWER_INCREASE_PERCENTAGE) / 100));
    }

    @Override
    public void setSuspension(int suspension) {
        super.setSuspension(suspension - ((suspension * SUSPENSION_INCREASE_PERCENTAGE) / 100));
    }
}
