package app.core;

import app.entities.device.Device;
import app.entities.exceptions.UnableToPayBillsException;
import app.entities.home.*;
import app.entities.people.Child;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class BusinessManager {
    private List<Home> homes;

    public BusinessManager() {
        this.homes = new ArrayList<>();
    }

    public void registerYoungCouple(String[] data) {
        double[] collected = Arrays.stream(data[0].substring(data[0].indexOf("(") + 1, data[0].indexOf(")")).split(",")).mapToDouble(Double::parseDouble).toArray();
        List<Device> devices = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            devices.add(new Device(Double.parseDouble(data[i].substring(data[i].indexOf("(") + 1, data[i].indexOf(")")))));
        }
        devices.add(new Device(Double.parseDouble(data[data.length - 1].substring(data[data.length - 1].indexOf("(") + 1, data[data.length - 1].indexOf(")")))));
        Home h = new YoungCouple(Arrays.stream(collected).sum(), devices);
        this.homes.add(h);
    }

    public void registerYoungCoupleWithChildren(String[] data) {
        double[] collected = Arrays.stream(data[0].substring(data[0].indexOf("(") + 1, data[0].indexOf(")")).split(",")).mapToDouble(Double::parseDouble).toArray();
        List<Device> devices = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Device currentDevice = new Device(Double.parseDouble(data[i].substring(data[i].indexOf("(") + 1, data[i].indexOf(")"))));
            devices.add(currentDevice);
        }
        devices.add(new Device(Double.parseDouble(data[3].substring(data[3].indexOf("(") + 1, data[3].indexOf(")")))));
        List<Child> children = new ArrayList<>();
        for (int i = 4; i < data.length; i++) {
            String[] childLine = data[i].substring(data[i].indexOf("(") + 1, data[i].indexOf(")")).split(",");
            double totalToysCost = 0D;
            for (int j = 1; j < childLine.length; j++) {
                totalToysCost += Double.parseDouble(childLine[j]);
            }
            children.add(new Child(Double.parseDouble(childLine[0]), totalToysCost));
        }
        Home h = new YoungCoupleWithChildren(Arrays.stream(collected).sum(), devices, children);
        this.homes.add(h);
    }

    public void registerAloneYoung(String[] data) {
        double salary = Double.parseDouble(data[0].substring(data[0].indexOf("(") + 1, data[0].indexOf(")")));
        List<Device> devices = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            devices.add(new Device(Double.parseDouble(data[i].substring(data[i].indexOf("(") + 1, data[i].indexOf(")")))));
        }
        Home h = new AloneYoung(salary, devices);
        this.homes.add(h);
    }

    public void registerAloneOld(String[] data) {
        double pension = Double.parseDouble(data[0].substring(data[0].indexOf("(") + 1, data[0].indexOf(")")));
        Home h = new AloneOld(pension);
        this.homes.add(h);
    }

    public void registerOldCouple(String[] data) {
        double[] collected = Arrays.stream(data[0].substring(data[0].indexOf("(") + 1, data[0].indexOf(")")).split(",")).mapToDouble(Double::parseDouble).toArray();
        List<Device> devices = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            devices.add(new Device(Double.parseDouble(data[i].substring(data[i].indexOf("(") + 1, data[i].indexOf(")")))));
        }
        Home h = new OldCouple(Arrays.stream(collected).sum(), devices);
        this.homes.add(h);
    }

    public void printPopulationCount() {
        int pop = 0;
        for (Home home : this.homes) {
            pop += home.getPopulation();
        }
        System.out.printf("Total population: %d", pop);
    }

    public void printTotalConsumption() {
        final Double[] totalCityConsumption = {0.0};
        homes.forEach(h -> totalCityConsumption[0] += h.getTotalConsumption());
        System.out.println("Total consumption: " + totalCityConsumption[0]);
    }

    public void payEvnBill() {
        List<Home> homesToRemove = new ArrayList<>();
        for (Home home : this.homes) {
            try {
                home.payBills(home.getTotalConsumption());
            } catch (UnableToPayBillsException upb) {
                homesToRemove.add(home);
            }
        }

        this.homes.removeAll(homesToRemove);
    }

    public void paySalaries() {
        for (Home home : this.homes) {
            home.addSalary(home.getSalary());
        }
    }
}
