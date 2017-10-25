package K_CatLady;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.setFurLength(furLength);
    }

    private double getFurLength() {
        return furLength;
    }

    private void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        String format = String.format("Cymric %s %.2f", this.getName(), this.getFurLength());
        return format;
    }
}
