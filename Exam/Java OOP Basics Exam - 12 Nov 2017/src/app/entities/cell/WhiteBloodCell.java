package app.entities.cell;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class WhiteBloodCell extends BloodCell {
    private int size;//– a positive integer that describes the size of the cell.


    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    @Override
    public int calculateEnergy() {
        return (this.getHealth() + size) * 2;
    }

    //toString
    @Override
    public String toString() {
        return super.toString().concat(
                String.format("--------Health: %d | Size: %d | Energy: %d", this.getHealth(), this.size, this.calculateEnergy())
        );
    }
}
