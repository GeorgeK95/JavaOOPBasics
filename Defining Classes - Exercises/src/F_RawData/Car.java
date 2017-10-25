package F_RawData;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.setModel(model);
        this.setEngine(engine);
        this.setCargo(cargo);
        this.setTires(tires);
    }

    String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    Tire[] getTires() {
        return tires;
    }

    public void setTires(Tire[] tires) {
        this.tires = tires;
    }
}
