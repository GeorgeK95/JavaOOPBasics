package app.factories;

import app.entities.bender.*;

import static app.utilities.Constants.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class BenderFactory {
    public static Bender generateBender(String type, String name, int power, double parameter) {
        switch (type) {
            case AIR_STRING:
                return new AirBender(name, power, parameter);
            case WATER_STRING:
                return new WaterBender(name, power, parameter);
            case FIRE_STRING:
                return new FireBender(name, power, parameter);
            case EARTH_STRING:
                return new EarthBender(name, power, parameter);
            default:
                return null;
        }
    }
}
