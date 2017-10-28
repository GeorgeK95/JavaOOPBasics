package pizzaCalories;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Topping extends Ingredient {

    private static final double MEAT = 1.2;
    private static final double VEGGIES = 0.8;
    private static final double CHEESE = 1.1;
    private static final double SAUCE = 0.9;

    Topping(String type, double weight) {
        super(type, weight);
    }

    @Override
    double calculateCalories() {
        return super.calculateCalories() * this.getTypeWeight();
    }

    public double getTypeWeight() {
        double typeWeight = 0D;
        if (this.getType().equalsIgnoreCase("Meat")) {
            typeWeight = MEAT;
        } else if (this.getType().equalsIgnoreCase("Veggies")) {
            typeWeight = VEGGIES;
        } else if (this.getType().equalsIgnoreCase("Cheese")) {
            typeWeight = CHEESE;
        } else if (this.getType().equalsIgnoreCase("Sauce")) {
            typeWeight = SAUCE;
        }

        return typeWeight;
    }

    @Override
    String getType() {
        return super.getType();
    }

    @Override
    void setType(String type) {
        if (!type.equalsIgnoreCase("Meat") && !type.equalsIgnoreCase("Veggies") && !type.equalsIgnoreCase("Cheese") && !type.equalsIgnoreCase("Sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        super.setType(type);
    }

    @Override
    double getWeight() {
        return super.getWeight();
    }

    @Override
    void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.getType()));
        }
        super.setWeight(weight);
    }
}
