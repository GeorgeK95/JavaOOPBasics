package G_CarSalesman;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    Car(String model, Engine engine, String weight, String color) {
        this.setModel(model);
        this.setEngine(engine);
        this.setWeight(weight);
        this.setColor(color);
    }

    @Override
    public String toString() {
        String format = String.format("%s:\n  %s\n  Weight: %s\n  Color: %s", this.getModel(), this.engine, this.getWeight(), this.getColor());
        return format;
    }

    private String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    Engine getEngine() {
        return engine;
    }

    private void setEngine(Engine engine) {
        this.engine = engine;
    }

    private String getWeight() {
        return weight;
    }

    private void setWeight(String weight) {
        this.weight = weight;
    }

    String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }
}
