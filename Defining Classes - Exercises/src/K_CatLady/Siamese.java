package K_CatLady;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.setEarSize(earSize);
    }

    double getEarSize() {
        return earSize;
    }

    private void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        String format = String.format("Siamese %s %.2f", this.getName(), this.getEarSize());
        return format;
    }
}
