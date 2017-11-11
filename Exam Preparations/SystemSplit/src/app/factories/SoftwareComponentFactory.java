package app.factories;

import app.entities.software.ExpressSoftwareComponent;
import app.entities.software.LightSoftwareComponent;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class SoftwareComponentFactory {
    public static ExpressSoftwareComponent createExpressSoftwareComponent(String name, int capacity, int memory) {
        return new ExpressSoftwareComponent(name, capacity, memory);
    }

    public static LightSoftwareComponent createLightSoftwareComponent(String name, int capacity, int memory) {
        return new LightSoftwareComponent(name, capacity, memory);
    }
}
