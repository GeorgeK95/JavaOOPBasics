package app.entities.race;

import app.entities.car.Car;

import java.util.*;
import java.util.stream.Collectors;

import static app.utilities.Constants.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s - %d", this.route, this.length));
        builder.append(System.lineSeparator());
        List<Car> winners = this.getWinners();
        List<Integer> winPercentages = new ArrayList<Integer>() {{
            add(FIRST_PRICE_POOL_PERCENTAGE);
            add(SECOND_PRICE_POOL_PERCENTAGE);
            add(THIRD_PRICE_POOL_PERCENTAGE);
        }};

        int c = 1;
        for (Car winner : winners) {
            builder.append(String.format("%d. %s %s %dPP - $%d", c, winner.getBrand(), winner.getModel(),
                    this.calculatePerformancePoints(winner), ((this.prizePool * winPercentages.get(c - 1)) / MAX_PERCENTAGE)));
            builder.append(System.lineSeparator());
            c++;
        }

        return builder.toString().trim();
    }

    protected int getPrizePool() {
        return prizePool;
    }

    protected String getRoute() {
        return route;
    }

    protected int getLength() {
        return length;
    }

    protected abstract int calculatePerformancePoints(Car car);

    protected List<Car> getWinners() {
        return this.participants.stream()
                .sorted((x, y) -> Integer.compare(this.calculatePerformancePoints(y), this.calculatePerformancePoints(x))).limit(3)
                .collect(Collectors.toList());
    }

    public void addParticipant(Car car) {
        this.participants.add(car);
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

}
