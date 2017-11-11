package app.entities.bender;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FireBender extends Bender {
    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.setHeatAggression(heatAggression);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("###Fire Bender: %s, Power: %d, Heat Aggression: %.2f",
                this.getName(), this.getPower(), this.getHeatAggression()));
        return builder.toString();
    }

    private double getHeatAggression() {
        return heatAggression;
    }

    private void setHeatAggression(double heatAggression) {
        this.heatAggression = heatAggression;
    }

    @Override
    public double calculateTotalPower() {
        return super.getPower() * this.getHeatAggression();
    }
}
