package wildFarm;

import java.text.DecimalFormat;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
abstract class Mammal extends Animal {
    private String livingRegion;

    Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]", super.getAnimalType(),
                super.getAnimalName(), new DecimalFormat("#.##").format(super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }

    String getLivingRegion() {
        return livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }
}
