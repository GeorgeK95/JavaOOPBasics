package K_CatLady;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class StreetExtraordinaire extends Cat {
    private double decibels;

    public StreetExtraordinaire(String name, double decibels) {
        super(name);
        this.setDecibels(decibels);
    }

    double getDecibels() {
        return decibels;
    }

    private void setDecibels(double decibels) {
        this.decibels = decibels;
    }

    @Override
    public String toString() {
        String format = String.format("StreetExtraordinaire %s %.2f", this.getName(), this.getDecibels());
        return format;
    }
}
