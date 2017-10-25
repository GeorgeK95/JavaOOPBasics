package I_Google;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Car {
    private String model;
    private int speed;

    Car(String model, int speed) {
        this.setModel(model);
        this.setSpeed(speed);
    }

    @Override
    public String toString() {
        return this.getModel() + " " + this.getSpeed();
    }

    private String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private int getSpeed() {
        return speed;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }
}
