package app.factories;

import app.entities.race.CasualRace;
import app.entities.race.DragRace;
import app.entities.race.DriftRace;
import app.entities.race.bonus.CircuitRace;
import app.entities.race.bonus.TimeLimitRace;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class RaceFactory {
    public static DriftRace createDriftRace(int length, String route, int prizePool) {
        return new DriftRace(length, route, prizePool);
    }

    public static DragRace createDragRace(int length, String route, int prizePool) {
        return new DragRace(length, route, prizePool);
    }

    public static CasualRace createCasualRace(int length, String route, int prizePool) {
        return new CasualRace(length, route, prizePool);
    }

    public static TimeLimitRace createTimeLimitRace(int length, String route, int prizePool, int param) {
        return new TimeLimitRace(length, route, prizePool, param);
    }

    public static CircuitRace createCircuitRace(int length, String route, int prizePool, int param) {
        return new CircuitRace(length, route, prizePool, param);
    }
}
