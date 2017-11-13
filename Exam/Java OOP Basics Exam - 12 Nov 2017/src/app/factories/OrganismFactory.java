package app.factories;

import app.entities.Organism;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class OrganismFactory {
    public static Organism createOrganism(String name) {
        return new Organism(name);
    }
}
