package app.entities.cell;

import app.entities.Cell;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class BloodCell extends Cell {

    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

}
