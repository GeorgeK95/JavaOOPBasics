package app.entities.cell;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RedBloodCell extends BloodCell {
    private int velocity;//– a positive integer that describes the size of the cell.

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    @Override
    public int calculateEnergy() {
        return this.getHealth() + velocity;
    }

    //toString
    @Override
    public String toString() {
        return super.toString().concat(
                String.format("--------Health: %d | Velocity: %d | Energy: %d", this.getHealth(), this.velocity, this.calculateEnergy()));
    }
}
