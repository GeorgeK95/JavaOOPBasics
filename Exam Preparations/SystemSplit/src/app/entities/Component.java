package app.entities;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Component {
    private String name;
    private String type;
    private int memory;
    private int capacity;

    public Component(String name, String type, int capacity, int memory) {
        this.name = name;
        this.setCapacity(capacity);
        this.setMemory(memory);
        this.type = type;
    }

    protected void setMemory(int memory) {
        this.memory = memory;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getMemory() {
        return memory;
    }

    public int getCapacity() {
        return capacity;
    }
}
