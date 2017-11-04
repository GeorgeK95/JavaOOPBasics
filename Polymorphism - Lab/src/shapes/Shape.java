package shapes;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
abstract class Shape {
    private double perimeter;
    private double area;

    abstract void calculateArea();

    abstract void calculatePerimeter();

    double getPerimeter() {
        return perimeter;
    }

    void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    double getArea() {
        return area;
    }

    void setArea(double area) {
        this.area = area;
    }
}
