package app.entities.race.bonus;

import app.entities.car.Car;
import app.entities.race.Race;

import static app.utilities.Constants.BRONZE_TIME_PERCENTAGE;
import static app.utilities.Constants.EMPTY_STRING;
import static app.utilities.Constants.SILVER_TIME_PERCENTAGE;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    @Override
    public String toString() {
        if (this.getParticipants().size() == 1) {
            int calculatedTime = this.calculatePerformancePoints(super.getParticipants().get(0));
            String earnedTime = this.getEarnedTime(calculatedTime);
            StringBuilder builder = new StringBuilder();

            builder.append(String.format("%s - %s", super.getRoute(), super.getLength()));
            builder.append(System.lineSeparator());
            builder.append(String.format("%s %s - %d s.", super.getParticipants().get(0).getBrand(),
                    super.getParticipants().get(0).getModel(), calculatedTime));
            builder.append(System.lineSeparator());
            builder.append(String.format("%s, $%d.", earnedTime, this.getWonPrize(earnedTime)));

            return builder.toString();
        }

        return EMPTY_STRING;
    }

    @Override
    public void addParticipant(Car car) {
        if (super.getParticipants().size() == 0) {
            super.addParticipant(car);
        }
    }

    private int getWonPrize(String earnedTime) {
        switch (earnedTime) {
            case "Gold Time":
                return super.getPrizePool();
            case "Silver Time":
                return (super.getPrizePool() * SILVER_TIME_PERCENTAGE) / 100;
            case "Bronze Time":
                return (super.getPrizePool() * BRONZE_TIME_PERCENTAGE) / 100;
        }
        return 0;
    }

    private String getEarnedTime(int tp) {
        if (tp <= this.goldTime) {
            return "Gold Time";
        } else if (tp <= this.goldTime + 15) {
            return "Silver Time";
        } else /*if (tp > this.goldTime + 15) {*/
            return "Bronze Time";
//    }

    }

    @Override
    protected int calculatePerformancePoints(Car car) {
        return super.getLength() * ((car.getHorsepower() / 100) * car.getAcceleration());
    }
}
