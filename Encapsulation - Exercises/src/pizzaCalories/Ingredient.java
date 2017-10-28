package pizzaCalories;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Ingredient {
    private String type;
    private static final int baseWeight = 2;
    private double weight;

    Ingredient(String type, double weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    double calculateCalories() {
        return baseWeight * this.getWeight();
    }

    String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    static int getBaseWeight() {
        return baseWeight;
    }

    double getWeight() {
        return weight;
    }

    void setWeight(double weight) {
        this.weight = weight;
    }
}
