package wildFarm;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Mouse extends Mammal {

    Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {
        if (food.getClass() != Vegetable.class) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
