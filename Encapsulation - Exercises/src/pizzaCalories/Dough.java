package pizzaCalories;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Dough extends Ingredient {

    private static final double WHITE = 1.5;
    private static final double WHOLEGRAIN = 1.0;
    private static final double CRISPY = 0.9;
    private static final double CHEWY = 1.1;
    private static final double HOMEMADE = 1.0;

    private String color;

    Dough(String color, String type, double weight) {
        super(type, weight);
        this.setColor(color);
    }

    private String getColor() {
        return color;
    }

    private void setColor(String color) {
        if (!color.equalsIgnoreCase("White") && !color.equalsIgnoreCase("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.color = color;
    }

    private double getTypeWeightCalories() {
        double colorWeight = 0D;
        if (this.getColor().equalsIgnoreCase("White")) {
            colorWeight = WHITE;
        } else if (this.getColor().equalsIgnoreCase("Wholegrain")) {
            colorWeight = WHOLEGRAIN;
        }

        double typeWeight = 0D;
        if (this.getType().equalsIgnoreCase("Crispy")) {
            typeWeight = CRISPY;
        } else if (this.getType().equalsIgnoreCase("Chewy")) {
            typeWeight = CHEWY;
        } else if (this.getType().equalsIgnoreCase("Homemade")) {
            typeWeight = HOMEMADE;
        }

        return typeWeight * colorWeight;
    }

    @Override
    double calculateCalories() {
        return super.calculateCalories() * this.getTypeWeightCalories();
    }

    @Override
    String getType() {
        return super.getType();
    }

    @Override
    void setType(String type) {
        if (!type.equalsIgnoreCase("Crispy") && !type.equalsIgnoreCase("Chewy") && !type.equalsIgnoreCase("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        super.setType(type);
    }

    @Override
    double getWeight() {
        return super.getWeight();
    }

    @Override
    void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        super.setWeight(weight);
    }
}
