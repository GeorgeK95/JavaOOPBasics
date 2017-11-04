package wildFarm;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Tiger extends Felime {

    Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (food.getClass() != Meat.class) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
