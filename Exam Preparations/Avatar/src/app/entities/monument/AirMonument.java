package app.entities.monument;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AirMonument extends Monument {
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.setAirAffinity(airAffinity);
    }

    private int getAirAffinity() {
        return airAffinity;
    }

    private void setAirAffinity(int airAffinity) {
        this.airAffinity = airAffinity;
    }

    @Override
    public int getAffinity() {
        return this.getAirAffinity();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("###Air Monument: %s, Air Affinity: %d",
                this.getName(), this.getAirAffinity()));
        return builder.toString();
    }
}
