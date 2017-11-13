package app.factories;

import app.entities.Cell;
import app.entities.cell.RedBloodCell;
import app.entities.cell.WhiteBloodCell;
import app.entities.microbe.Bacteria;
import app.entities.microbe.Fungi;
import app.entities.microbe.Virus;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class CellFactory {
    public static Cell createCell(String cellType, String cellId, int health
            , int positionRow, int positionCol, int additionalProperty) {
        switch (cellType) {
            case "WhiteBloodCell":
                return new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case "RedBloodCell":
                return new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case "Virus":
                return new Virus(cellId, health, positionRow, positionCol, additionalProperty);
            case "Fungi":
                return new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
            case "Bacteria":
                return new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
        }
        return null;
    }
}
