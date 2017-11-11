package app.entities.hardware;

import static app.utilities.Constants.POWER_HARDWARE_DECREASE_CAPACITY_PERCENTAGE;
import static app.utilities.Constants.POWER_HARDWARE_INCREASE_MEMORY_PERCENTAGE;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class PowerHardwareComponent extends HardwareComponent {
    private static final String TYPE = "Power";

    public PowerHardwareComponent(String name, int maximumCapacity, int maximumMemory) {
        super(name, TYPE,maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMemory(int memory) {
        super.setMemory(memory + (memory * POWER_HARDWARE_INCREASE_MEMORY_PERCENTAGE) / 100);
    }

    @Override
    protected void setCapacity(int capacity) {
        super.setCapacity(capacity - (capacity * POWER_HARDWARE_DECREASE_CAPACITY_PERCENTAGE) / 100);
    }
}
