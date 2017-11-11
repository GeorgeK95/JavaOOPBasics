package app.entities.people;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Child {
    private double foodCost;
    private double toyCost;

    public Child(double foodCost, double toyCost) {
        this.foodCost = foodCost;
        this.toyCost = toyCost;
    }

    public double getTotalChildCost() {
        return this.getFoodCost() + this.getToyCost();
    }

    public double getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    public double getToyCost() {
        return toyCost;
    }

    public void setToyCost(double toyCost) {
        this.toyCost = toyCost;
    }
}
