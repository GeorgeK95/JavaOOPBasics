package app.entities.hardware;

import app.entities.Component;
import app.entities.software.SoftwareComponent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class HardwareComponent extends Component {

    private Map<String, SoftwareComponent> softwareComponents;
    private int currentTakenMemory;
    private int currentTakenCapacity;

    HardwareComponent(String name, String type, int capacity, int memory) {
        super(name, type, capacity, memory);
        this.softwareComponents = new LinkedHashMap<>();
    }

    public Map<String, SoftwareComponent> getSoftwareComponents() {
        return softwareComponents;
    }


    private String getSoftwareComponentsNamesFormatted() {
        List<String> names = new ArrayList<>();
        for (SoftwareComponent softwareComponent : softwareComponents.values()) {
            names.add(softwareComponent.toString());
        }
        return this.softwareComponents.size() > 0 ? String.join(", ", names) : "None";
    }

    @Override
    public String toString() {
        String builder = String.format("Hardware Component - %s\n", this.getName()) +
                String.format("Express Software Components - %d\n", this.getSoftwareComponents().values().stream().filter(x -> x.getType().equals("Express")).collect(Collectors.toList()).size()) +
                String.format("Light Software Components - %d\n", this.getSoftwareComponents().values().stream().filter(x -> x.getType().equals("Light")).collect(Collectors.toList()).size()) +
                String.format("Memory Usage: %d / %d\n", this.getCurrentTakenMemory(), this.getMemory()) +
                String.format("Capacity Usage: %d / %d\n", this.getCurrentTakenCapacity(), this.getCapacity()) +
                String.format("Type: %s", this.getType()) + "\n" +
                String.format("Software Components: %s\n", this.getSoftwareComponentsNamesFormatted());

        return builder;
    }

    public int getSoftwareComponentsSize() {
        return softwareComponents.size();
    }

    public void registerSoftwareComponent(SoftwareComponent component) {
        if (this.getMemory() - this.getCurrentTakenMemory() >= component.getMemory() &&
                super.getCapacity() - this.getCurrentTakenCapacity() >= component.getCapacity()) {
            this.currentTakenMemory += component.getMemory();
            this.currentTakenCapacity += component.getCapacity();
            this.softwareComponents.put(component.getName(), component);
        }
    }

    public void releaseSoftwareComponent(String softwareComponentName) {
        if (this.softwareComponents.containsKey(softwareComponentName)) {
            this.currentTakenMemory -= this.softwareComponents.get(softwareComponentName).getMemory();
            this.currentTakenCapacity -= this.softwareComponents.get(softwareComponentName).getCapacity();
            this.softwareComponents.remove(softwareComponentName);
        }
    }


    public int getCurrentTakenMemory() {
        return currentTakenMemory;
    }

    public int getCurrentTakenCapacity() {
        return currentTakenCapacity;
    }
}
