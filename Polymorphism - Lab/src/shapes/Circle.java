package shapes;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Circle extends Shape {
    private double radius;

    @Override
    void calculateArea() {
        super.setPerimeter(this.getRadius() * this.getRadius() * Math.PI);
    }

    @Override
    void calculatePerimeter() {
        super.setArea(this.getRadius() * 2 * Math.PI);
    }

    private final double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }
}
