package app.entities.monument;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class EarthMonument extends Monument {
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.setEarthAffinity(earthAffinity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("###Earth Monument: %s, Earth Affinity: %d",
                this.getName(), this.getEarthAffinity()));
        return builder.toString();
    }

    private int getEarthAffinity() {
        return earthAffinity;
    }

    @Override
    public int getAffinity() {
        return this.getEarthAffinity();
    }

    private void setEarthAffinity(int earthAffinity) {
        this.earthAffinity = earthAffinity;
    }
}
