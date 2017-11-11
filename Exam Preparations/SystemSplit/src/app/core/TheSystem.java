package app.core;

import app.entities.Component;
import app.entities.hardware.HardwareComponent;
import app.entities.software.SoftwareComponent;
import app.factories.HardwareComponentFactory;
import app.factories.SoftwareComponentFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class TheSystem {
    private Map<String, HardwareComponent> hardwareComponents;
    private Map<String, HardwareComponent> dumpComponents;

    public TheSystem() {
        this.hardwareComponents = new LinkedHashMap<>();
        this.dumpComponents = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        this.hardwareComponents.put(name, HardwareComponentFactory.createPowerHardwareComponent(name, capacity, memory));
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        this.hardwareComponents.put(name, HardwareComponentFactory.createHeavyHardwareComponent(name, capacity, memory));
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            this.hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(
                    SoftwareComponentFactory.createExpressSoftwareComponent(name, capacity, memory));
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            this.hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(
                    SoftwareComponentFactory.createLightSoftwareComponent(name, capacity, memory));
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            this.hardwareComponents.get(hardwareComponentName).releaseSoftwareComponent(softwareComponentName);
        }
    }

    public String analyze() {
        String builder = "System Analysis\n" +
                "Hardware Components: " + this.hardwareComponents.size() + "\n" +
                "Software Components: " + this.getSoftwareComponentsSize() + "\n" +
                String.format("Total Operational Memory: %d / %d\n", this.getTotalOperationalMemory()
                        , this.hardwareComponents.values().stream().mapToInt(Component::getMemory).sum()) +
                String.format("Total Capacity Taken: %d / %d", this.getTotalCapacity()
                        , this.hardwareComponents.values().stream().mapToInt(Component::getCapacity).sum());

        return builder;
    }

    private int getTotalCapacity() {
        int result = 0;
        for (Map.Entry<String, HardwareComponent> pair : this.hardwareComponents.entrySet()) {
            for (SoftwareComponent softwareComponent : pair.getValue().getSoftwareComponents().values()) {
                result += softwareComponent.getCapacity();
            }
        }
        return result;
    }

    private int getTotalOperationalMemory() {
        int result = 0;
        for (Map.Entry<String, HardwareComponent> pair : this.hardwareComponents.entrySet()) {
            for (SoftwareComponent softwareComponent : pair.getValue().getSoftwareComponents().values()) {
                result += softwareComponent.getMemory();
            }
        }
        return result;
    }

    private int getSoftwareComponentsSize() {
        int result = 0;
        for (Map.Entry<String, HardwareComponent> pair : this.hardwareComponents.entrySet()) {
            result += pair.getValue().getSoftwareComponentsSize();
        }
        return result;
    }

    public String split() {
        StringBuilder builder = new StringBuilder();
        this.generateHardwareComponentOutput(builder, "Power");
        this.generateHardwareComponentOutput(builder, "Heavy");
        return builder.toString();
    }

    private void generateHardwareComponentOutput(StringBuilder builder, String type) {
        for (HardwareComponent current : this.hardwareComponents.values().stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList())) {
            builder.append(current.toString());
        }
    }

    public void dumpSoftware(String hardwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            this.dumpComponents.put(hardwareComponentName, this.hardwareComponents.get(hardwareComponentName));
            this.hardwareComponents.remove(hardwareComponentName);
        }
    }

    public void restoreSoftware(String hardwareComponentName) {
        if (this.dumpComponents.containsKey(hardwareComponentName)) {
            this.hardwareComponents.put(hardwareComponentName, this.dumpComponents.get(hardwareComponentName));
        }
        this.destroySoftware(hardwareComponentName);
    }

    public void destroySoftware(String hardwareComponentName) {
        if (this.dumpComponents.containsKey(hardwareComponentName)) {
            this.dumpComponents.remove(hardwareComponentName);
        }
    }

    public String dumpAnalyze() {
        String builder = "Dump Analysis\n" +
                String.format("Power Hardware Components: %d\n", this.dumpComponents.values().stream().filter(x -> x.getType().equals("Power")).collect(Collectors.toList()).size()) +
                String.format("Heavy Hardware Components: %d\n", this.dumpComponents.values().stream().filter(x -> x.getType().equals("Heavy")).collect(Collectors.toList()).size()) +
                String.format("Express Software Components: %d\n", getExpressSoftwareComponentsCount()) +
                String.format("Light Software Components: %d\n", getLightSoftwareComponentsCount()) +
                String.format("Total Dumped Memory: %d\n", this.dumpComponents.values().stream().mapToInt(HardwareComponent::getCurrentTakenMemory).sum()) +
                String.format("Total Dumped Capacity: %d", this.dumpComponents.values().stream().mapToInt(HardwareComponent::getCurrentTakenCapacity).sum());
        return builder;
    }

    private int getLightSoftwareComponentsCount() {
        int result = 0;
        for (HardwareComponent hardwareComponent : this.dumpComponents.values()) {
            result += hardwareComponent.getSoftwareComponents().values().stream()
                    .filter(x -> x.getType().equals("Light")).collect(Collectors.toList()).size();
        }
        return result;
    }

    private int getExpressSoftwareComponentsCount() {
        int result = 0;
        for (HardwareComponent hardwareComponent : this.dumpComponents.values()) {
            result += hardwareComponent.getSoftwareComponents().values().stream()
                    .filter(x -> x.getType().equals("Express")).collect(Collectors.toList()).size();
        }
        return result;
    }
}
