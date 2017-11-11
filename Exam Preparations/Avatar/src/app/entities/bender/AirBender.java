package app.entities.bender;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AirBender extends Bender {
    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.setAerialIntegrity(aerialIntegrity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("###Air Bender: %s, Power: %d, Aerial Integrity: %.2f",
                this.getName(), this.getPower(), this.getAerialIntegrity()));
        return builder.toString();
    }

    private double getAerialIntegrity() {
        return aerialIntegrity;
    }

    private void setAerialIntegrity(double aerialIntegrity) {
        this.aerialIntegrity = aerialIntegrity;
    }

    @Override
    public double calculateTotalPower() {
        return super.getPower() * this.getAerialIntegrity();
    }
}
