package app.core;

import app.entities.bender.Bender;
import app.entities.monument.*;
import app.factories.BenderFactory;
import app.factories.MonumentFactory;

import java.util.*;

import static app.utilities.Constants.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class BusinessManager {
    private Map<String, List<Monument>> monuments;
    private Map<String, List<Bender>> benders;

    private Deque<String> wars;

    public BusinessManager() {
        initializeData();
        this.wars = new ArrayDeque<>();
    }

    private void initializeData() {
        initializeBenders();
        initializeMonuments();
    }

    private void initializeMonuments() {
        this.monuments = new LinkedHashMap<>();
        this.monuments.put(AIR_STRING, new ArrayList<>());
        this.monuments.put(WATER_STRING, new ArrayList<>());
        this.monuments.put(FIRE_STRING, new ArrayList<>());
        this.monuments.put(EARTH_STRING, new ArrayList<>());
    }

    private void initializeBenders() {
        this.benders = new LinkedHashMap<>();
        this.benders.put(AIR_STRING, new ArrayList<>());
        this.benders.put(WATER_STRING, new ArrayList<>());
        this.benders.put(FIRE_STRING, new ArrayList<>());
        this.benders.put(EARTH_STRING, new ArrayList<>());
    }

    public void createBender(String type, String name, int power, double parameter) {
        this.benders.get(type).add(BenderFactory.generateBender(type, name, power, parameter));
    }

    public void createMonument(String type, String name, int affinity) {
        this.monuments.get(type).add(MonumentFactory.generateMonument(type, name, affinity));
    }

    public void printStatus(String nation) {
        StringBuilder builder = new StringBuilder();
        builder.append(nation).append(" Nation");
        builder.append("\r\nBenders:");
        appendBenders(builder, nation);
        builder.append("\r\nMonuments:");
        appendMonuments(builder, nation);
        System.out.println(builder);
    }

    private void appendMonuments(StringBuilder builder, String nation) {
        List<Monument> bendersFound = this.monuments.get(nation);
        if (bendersFound.size() > 0) {
            for (Monument monument : bendersFound) {
                builder.append("\r\n").append(monument.toString());
            }
        } else {
            builder.append(" None");
        }
    }

    private void appendBenders(StringBuilder builder, String nation) {
        List<Bender> bendersFound = this.benders.get(nation);
        if (bendersFound.size() > 0) {
            for (Bender bender : bendersFound) {
                builder.append("\r\n").append(bender.toString());
            }
        } else {
            builder.append(" None");
        }
    }

    public void startWar(String nation) {
        this.wars.addLast(nation);
        double bestPower = 0;
        String winningNation = nation;

        for (Map.Entry<String, List<Bender>> pair : this.benders.entrySet()) {
            double currentTotalPower = getCurrentTotalPower(pair.getValue());
            double currentMonumentsBonus = getCurrentMonumentsBonus(pair.getKey(), currentTotalPower);
            currentTotalPower += currentMonumentsBonus;

            if (currentTotalPower > bestPower) {
                bestPower = currentTotalPower;
                winningNation = pair.getKey();
            }
        }

        String finalWinningNation = winningNation;
        this.benders.entrySet().stream().filter(x -> !x.getKey().equals(finalWinningNation)).forEach(y -> y.getValue().clear());
        this.monuments.entrySet().stream().filter(x -> !x.getKey().equals(finalWinningNation)).forEach(y -> y.getValue().clear());
    }

    private double getCurrentMonumentsBonus(String nation, double totalPower) {
        double affinity = 0;
        for (Monument monument : this.monuments.get(nation)) {
            affinity += monument.getAffinity();
        }
        return (totalPower / 100) * affinity;
    }

    private double getCurrentTotalPower(List<Bender> value) {
        double result = 0;
        for (Bender bender : value) {
            result += bender.calculateTotalPower();
        }
        return result;
    }

    public void printIssuedWars() {
        int c = 1;
        while (!this.wars.isEmpty()) {
            System.out.printf("War %d issued by %s%n", c, this.wars.pop());
            c++;
        }
    }
}
