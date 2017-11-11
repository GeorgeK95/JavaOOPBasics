package app.entities.software;

import static app.utilities.Constants.EXPRESS_SOFTWARE_INCREASE_MEMORY_CONSUMPTION_PERCENTAGE;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ExpressSoftwareComponent extends SoftwareComponent {
    private static final String TYPE = "Express";

    public ExpressSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, TYPE, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setMemory(int memory) {
        super.setMemory(memory + (memory * EXPRESS_SOFTWARE_INCREASE_MEMORY_CONSUMPTION_PERCENTAGE) / 100);
    }


}
