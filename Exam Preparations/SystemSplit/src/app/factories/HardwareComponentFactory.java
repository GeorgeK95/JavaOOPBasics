package app.factories;

import app.entities.hardware.HeavyHardwareComponent;
import app.entities.hardware.PowerHardwareComponent;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class HardwareComponentFactory {
    public static PowerHardwareComponent createPowerHardwareComponent(String name, int capacity, int memory) {
        return new PowerHardwareComponent(name, capacity, memory);
    }

    public static HeavyHardwareComponent createHeavyHardwareComponent(String name, int capacity, int memory) {
        return new HeavyHardwareComponent(name, capacity, memory);
    }
}
