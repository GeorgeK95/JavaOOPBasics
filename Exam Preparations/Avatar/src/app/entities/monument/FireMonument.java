package app.entities.monument;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FireMonument extends Monument {
    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.setFireAffinity(fireAffinity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("###Fire Monument: %s, Fire Affinity: %d",
                this.getName(), this.getFireAffinity()));
        return builder.toString();
    }

    private int getFireAffinity() {
        return fireAffinity;
    }

    @Override
    public int getAffinity() {
        return this.getFireAffinity();
    }

    private void setFireAffinity(int fireAffinity) {
        this.fireAffinity = fireAffinity;
    }
}
