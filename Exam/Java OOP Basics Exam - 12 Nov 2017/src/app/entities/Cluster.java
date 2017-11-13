package app.entities;

import app.entities.cell.BloodCell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Cluster {
    private String id;// – a string that describes the name of the cluster, unique property;
    private int rows;//– a positive integer that describes how many rows the cluster has;
    private int cols;//– a positive integer that describes how many columns the cluster has;
    private List<Cell> cells;// – a collection of objects of type Cell;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    void activateCluster() {
        Cell closest = this.getClosestCell(0, 0);
        if (closest != null) {
            //move cell

            while (true) {
                if (!this.checkForOtherCells(closest.getPositionRow(), closest.getPositionCol())) {
                    break;
                }
                closest = moveCell(closest);
            }

        }
    }

    private Cell moveCell(Cell start) {
        int r = start.getPositionRow();
        int c = start.getPositionCol();

        if (c + 1 > this.rows) {
            r += 1;
            c = 0;
        } else {
            c += 1;
        }

        Cell next = this.getCellByCoordinates(r, c);
        Cell winner = null;

        if (next != null) {
            winner = fight(start, next);
            winner.setPositionRow(r);
            winner.setPositionCol(c);
        } else {
            start.setPositionRow(r);
            start.setPositionCol(c);
            return start;
        }

        return winner;
    }

    private Cell getCellByCoordinates(int r, int c) {
        for (Cell cell : cells) {
            if (cell.getPositionRow() == r && cell.getPositionCol() == c) {
                return cell;
            }
        }
        return null;
    }

    private Cell fight(Cell start, Cell next) {
        if (start instanceof BloodCell) {
            start.setHealth(start.getHealth() + next.getHealth());
            this.cells.remove(next); //check
        } else {
            while (true) {
                //1 -> 2
                next.setHealth(next.getHealth() - start.calculateEnergy());
                if (next.getHealth() <= 0) {
                    //start wins, next -> KO
                    this.cells.remove(next);//check
                    return start;
                }
                //2 -> 1
                start.setHealth(start.getHealth() - next.calculateEnergy());
                if (start.getHealth() <= 0) {
                    //next wins, start -> KO
                    this.cells.remove(start);//check
                    return next;
                }

            }
        }
        return start;
    }

    private boolean checkForOtherCells(int positionRow, int positionCol) {
        Cell closestCell = this.getClosestCell(positionRow, positionCol + 1);
        return closestCell != null;
    }

    private Cell getClosestCell(int rowParam, int colParam) {
        for (int currentRow = rowParam; currentRow <= this.rows; currentRow++) {
            for (int currentCol = colParam; currentCol <= this.cols; currentCol++) {
                for (Cell cell : this.cells) {
                    if (cell.getPositionRow() == currentRow && cell.getPositionCol() == currentCol) {
                        return cell;
                    }
                }
            }
            colParam = 0;
        }
        return null;
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    //GETTERS
    int getCellsSize() {
        return this.rows * this.cols;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public String getId() {
        return id;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("----Cluster %s", this.id));
        builder.append(System.lineSeparator());

        List<Cell> ordered = this.cells.stream().sorted(Comparator.comparing(Cell::getPositionRow).thenComparing(Cell::getPositionCol))
                .collect(Collectors.toList());
        for (Cell cell : ordered) {
            builder.append(cell.toString());
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
