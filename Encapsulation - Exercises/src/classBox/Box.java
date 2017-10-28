package classBox;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Box {
    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    double calculateVolume() {
        return length * height * width;
    }

    double calculateLateralArea() {
        return 2 * length * height + 2 * width * height;
    }

    double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    double getLength() {
        return length;
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f\n" +
                "Lateral Surface Area - %.2f\n" +
                "Volume - %.2f\n", this.calculateSurfaceArea(), this.calculateLateralArea(), this.calculateVolume());
    }
}
