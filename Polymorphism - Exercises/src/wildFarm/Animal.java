package wildFarm;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    Animal(String animalName, String animalType, double animalWeight) {
        this.setAnimalName(animalName);
        this.setAnimalType(animalType);
        this.setAnimalWeight(animalWeight);
    }

    abstract void makeSound();

    abstract void eat(Food food);

    String getAnimalName() {
        return animalName;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    String getAnimalType() {
        return animalType;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    double getAnimalWeight() {
        return animalWeight;
    }

    private void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

    int getFoodEaten() {
        return foodEaten;
    }

    void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }
}
