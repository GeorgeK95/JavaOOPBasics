package app.entities.room;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Room {
    private double lightCost;

    public Room(double lightCost) {
        this.setLightCost(lightCost);
    }

    public double getLightCost() {
        return lightCost;
    }

    public void setLightCost(double lightCost) {
        this.lightCost = lightCost;
    }
}
