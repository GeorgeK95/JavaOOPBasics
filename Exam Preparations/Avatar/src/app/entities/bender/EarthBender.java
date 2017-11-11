package app.entities.bender;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class EarthBender extends Bender {
    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.setGroundSaturation(groundSaturation);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("###Earth Bender: %s, Power: %d, Ground Saturation: %.2f",
                this.getName(), this.getPower(), this.getGroundSaturation()));
        return builder.toString();
    }

    private double getGroundSaturation() {
        return groundSaturation;
    }

    private void setGroundSaturation(double groundSaturation) {
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double calculateTotalPower() {
        return super.getPower() * this.getGroundSaturation();
    }
}
