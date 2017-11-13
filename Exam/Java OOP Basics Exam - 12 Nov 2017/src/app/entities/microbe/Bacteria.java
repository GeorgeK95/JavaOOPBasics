package app.entities.microbe;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Bacteria extends Microbe {

    public Bacteria(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int calculateEnergy() {
        return (this.getHealth() + this.getVirulence()) / 3;
    }
}
