package app.entities.bender;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Bender {
    private String name;
    private int power;

    Bender(String name, int power) {
        this.setName(name);
        this.setPower(power);
    }

    @Override
    public abstract String toString();

    public abstract double calculateTotalPower();

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }
}
