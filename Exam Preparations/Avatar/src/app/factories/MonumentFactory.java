package app.factories;

import app.entities.monument.*;

import static app.utilities.Constants.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class MonumentFactory {
    public static Monument generateMonument(String type, String name, int affinity) {
        switch (type) {
            case AIR_STRING:
                return new AirMonument(name, affinity);
            case WATER_STRING:
                return new WaterMonument(name, affinity);
            case FIRE_STRING:
                return new FireMonument(name, affinity);
            case EARTH_STRING:
                return new EarthMonument(name, affinity);
            default:
                return null;
        }
    }
}
