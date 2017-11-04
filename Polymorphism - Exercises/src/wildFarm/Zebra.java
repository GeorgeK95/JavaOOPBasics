package wildFarm;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Zebra extends Mammal {

    Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (food.getClass() != Vegetable.class) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
