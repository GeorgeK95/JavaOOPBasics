package shapes;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Rectangle extends Shape {
    private double height;
    private double width;


    @Override
    void calculateArea() {
        super.setPerimeter(this.getWidth() * this.getHeight());
    }

    @Override
    void calculatePerimeter() {
        super.setArea(2 * (this.getWidth() + this.getHeight()));
    }

    private double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

}
