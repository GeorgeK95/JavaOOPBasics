package app.entities.car;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void tune(int tuneIndex, String addOn) {
        this.horsepower += tuneIndex;
        this.suspension += ((tuneIndex * 50) / 100);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s %s %d", this.brand, this.model, this.yearOfProduction));
        builder.append(System.lineSeparator());
        builder.append(String.format("%d HP, 100 m/h in %d s", this.horsepower, this.acceleration));
        builder.append(System.lineSeparator());
        builder.append(String.format("%d Suspension force, %d Durability", this.suspension, this.durability));
        builder.append(System.lineSeparator());

        return builder.toString();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }
}
