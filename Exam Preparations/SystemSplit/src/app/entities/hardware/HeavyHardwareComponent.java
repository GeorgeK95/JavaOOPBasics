package app.entities.hardware;

import static app.utilities.Constants.HEAVY_HARDWARE_DECREASE_MEMORY_PERCENTAGE;
import static app.utilities.Constants.HEAVY_HARDWARE_INCREASE_CAPACITY_PERCENTAGE;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class HeavyHardwareComponent extends HardwareComponent {
    private static final String TYPE = "Heavy";

    public HeavyHardwareComponent(String name, int maximumCapacity, int maximumMemory) {
        super(name, TYPE, maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMemory(int memory) {
        super.setMemory(memory - (memory * HEAVY_HARDWARE_DECREASE_MEMORY_PERCENTAGE) / 100);
    }

    @Override
    protected void setCapacity(int capacity) {
        super.setCapacity(capacity + (capacity * HEAVY_HARDWARE_INCREASE_CAPACITY_PERCENTAGE) / 100);
    }
}
