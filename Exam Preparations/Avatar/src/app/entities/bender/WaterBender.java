package app.entities.bender;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.setWaterClarity(waterClarity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("###Water Bender: %s, Power: %d, Water Clarity: %.2f",
                this.getName(), this.getPower(), this.getWaterClarity()));
        return builder.toString();
    }

    private double getWaterClarity() {
        return waterClarity;
    }

    private void setWaterClarity(double waterClarity) {
        this.waterClarity = waterClarity;
    }

    @Override
    public double calculateTotalPower() {
        return super.getPower() * this.getWaterClarity();
    }
}
