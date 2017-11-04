package methodOverriding;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Rectangle {
    private double height;
    private double weigh;

    Rectangle(double height, double weigh) {
        this.setHeight(height);
        this.setWeigh(weigh);
    }

    double area() {
        return this.getHeight() * this.getWeigh();
    }

    private double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private double getWeigh() {
        return weigh;
    }

    private void setWeigh(double weigh) {
        this.weigh = weigh;
    }
}
