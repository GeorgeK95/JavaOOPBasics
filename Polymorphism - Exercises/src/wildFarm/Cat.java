package wildFarm;

import java.text.DecimalFormat;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Cat extends Felime {
    private String catBreed;

    Cat(String animalName, String animalType, double animalWeight, String livingRegion, String catBreed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setCatBreed(catBreed);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", super.getAnimalType(),
                super.getAnimalName(),this.getCatBreed(), new DecimalFormat("#.##").format(super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    private String getCatBreed() {
        return catBreed;
    }

    private void setCatBreed(String catBreed) {
        this.catBreed = catBreed;
    }
}
