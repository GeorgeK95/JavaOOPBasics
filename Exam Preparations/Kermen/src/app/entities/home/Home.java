package app.entities.home;

import app.entities.device.Device;
import app.entities.exceptions.UnableToPayBillsException;
import app.entities.people.Child;
import app.entities.room.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Home {
    private double salary;
    private double budget;
    private List<Room> rooms;
    private List<Device> devices;
    private List<Child> children;

    Home(double income, List<Device> devices) {
        this.salary = income;//purvonachalnata i vechna zaplata
        this.budget = 0;//total budget
        this.setRooms();
        this.setDevices(devices);
        this.children = new ArrayList<>();
    }

    public void payBills(double bills) {
        if (this.budget < bills) {
            throw new UnableToPayBillsException();
        }
        this.budget -= bills;
    }

    public double getSalary() {
        return salary;
    }

    public void addSalary(double salary) {
        this.budget += salary;
    }

    public double getTotalConsumption() {
        double roomSum = this.rooms.stream().mapToDouble(Room::getLightCost).sum();
        double devicesSum = this.devices.stream().mapToDouble(Device::getElectricCost).sum();
        double childrenSum = this.children.stream().mapToDouble(Child::getTotalChildCost).sum();
        return roomSum + devicesSum + childrenSum;
    }

    public abstract int getPopulation();

    public List<Child> getChildren() {
        return children;
    }

    void setChildren(List<Child> children) {
        this.children = children;
    }

    protected void addRoom(Room room) {
        this.rooms.add(room);
    }

    protected void addDevice(Device device) {
        this.devices.add(device);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    protected abstract void setRooms();

    public List<Device> getDevices() {
        return devices;
    }

    private void setDevices(List<Device> devices) {
        if (devices == null) {
            this.devices = new ArrayList<>();
        } else {
            this.devices = devices;
        }
    }
}
