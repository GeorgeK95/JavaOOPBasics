package app.entities.software;

import app.entities.Component;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class SoftwareComponent extends Component {

    SoftwareComponent(String name, String type, int capacity, int memory) {
        super(name, type, capacity, memory);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
