package app.entities.monument;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class WaterMonument extends Monument {
    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.setWaterAffinity(waterAffinity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("###Water Monument: %s, Water Affinity: %d",
                this.getName(), this.getWaterAffinity()));
        return builder.toString();
    }

    private int getWaterAffinity() {
        return waterAffinity;
    }

    @Override
    public int getAffinity() {
        return this.getWaterAffinity();
    }

    private void setWaterAffinity(int waterAffinity) {
        this.waterAffinity = waterAffinity;
    }
}
