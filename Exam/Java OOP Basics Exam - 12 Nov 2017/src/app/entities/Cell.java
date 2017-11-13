package app.entities;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Cell {
    private String id; //, nonunique property;
    private int health; //a positive integer;
    private int positionRow;//– a positive integer;
    private int positionCol;//– a positive integer;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public abstract int calculateEnergy();

    //    GETTERS
    public int getPositionRow() {
        return positionRow;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public int getHealth() {
        return health;
    }

    //    SETTERS
    public void setHealth(int health) {
        this.health = health;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("------Cell %s [%d,%d]", this.id, this.positionRow, this.positionCol));
        builder.append(System.lineSeparator());
        return builder.toString();
    }
}
