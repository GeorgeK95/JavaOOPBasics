package app.entities.race.bonus;

import app.entities.car.Car;
import app.entities.race.Race;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static app.utilities.Constants.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    public void addParticipant(Car car) {
        super.addParticipant(car);
        this.setDurability(car);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s - %d", super.getRoute(), super.getLength() * this.laps));
        builder.append(System.lineSeparator());
        int c = 1;
        List<Car> winners = this.getWinners();
        List<Integer> podiums = new ArrayList<Integer>() {{
            add(FIRST_PLACE_PERCENTAGE);
            add(SECOND_PLACE_PERCENTAGE);
            add(THIRD_PLACE_PERCENTAGE);
            add(FOURTH_PLACE_PERCENTAGE);
        }};

        for (Car current : winners) {
            builder.append(String.format("%d. %s %s %dPP - $%d", c, current.getBrand(), current.getModel(),
                    this.calculatePerformancePoints(current), this.calculateMoneyWon(current, podiums.get(c - 1))));
            builder.append(System.lineSeparator());
            c++;
        }
        return builder.toString().trim();
    }

    private void setDurability(Car car) {
        int diff = super.getLength() * super.getLength() * this.laps;
        car.setDurability(car.getDurability() - diff);
    }

    private int calculateMoneyWon(Car current, int param) {
        return (super.getPrizePool() * param) / MAX_PERCENTAGE;
    }

    protected List<Car> getWinners() {
        return super.getParticipants().stream()
                .sorted((x, y) -> Integer.compare(this.calculatePerformancePoints(y), this.calculatePerformancePoints(x))).limit(4)
                .collect(Collectors.toList());
    }

    @Override
    protected int calculatePerformancePoints(Car car) {
        return (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability())/* - diff*/;
    }
}
