package app.entities.microbe;

import app.entities.Cell;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Microbe extends Cell {
    private int virulence;//– a positive integer that describes the ability of a microbe to infect other cells.

    Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    //GETTERS
    int getVirulence() {
        return virulence;
    }

    //toString
    @Override
    public String toString() {
        return super.toString().concat(
                String.format("--------Health: %d | Virulence: %d | Energy: %d", this.getHealth(), this.virulence, this.calculateEnergy())
        );
    }
}
