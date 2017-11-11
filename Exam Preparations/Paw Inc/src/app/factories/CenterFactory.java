package app.factories;

import app.entities.center.AdoptionCenter;
import app.entities.center.CleansingCenter;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class CenterFactory {
    public static AdoptionCenter generateAdoptionCenter(String name) {
        return new AdoptionCenter(name);
    }

    public static CleansingCenter generateCleansingCenter(String name) {
        return new CleansingCenter(name);
    }
}
