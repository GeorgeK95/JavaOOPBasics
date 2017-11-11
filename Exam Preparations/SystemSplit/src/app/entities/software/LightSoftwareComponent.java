package app.entities.software;

import static app.utilities.Constants.LIGHT_SOFTWARE_DECREASE_MEMORY_CONSUMPTION_PERCENTAGE;
import static app.utilities.Constants.LIGHT_SOFTWARE_INCREASE_CAPACITY_CONSUMPTION_PERCENTAGE;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class LightSoftwareComponent extends SoftwareComponent {
    private static final String TYPE = "Light";

    public LightSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, TYPE, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setMemory(int memory) {
        super.setMemory(memory - (memory * LIGHT_SOFTWARE_DECREASE_MEMORY_CONSUMPTION_PERCENTAGE) / 100);
    }

    @Override
    protected void setCapacity(int capacity) {
        super.setCapacity(capacity + (capacity * LIGHT_SOFTWARE_INCREASE_CAPACITY_CONSUMPTION_PERCENTAGE) / 100);
    }
}
