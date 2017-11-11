package app.entities.center;

import app.entities.animal.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static app.utilities.Constants.CLEANED_ANIMAL_STATUS;
import static app.utilities.Constants.UNCLEANED_ANIMAL_STATUS;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Center {
    private String name;
    private List<Animal> storedAnimals;

    protected Center(String name) {
        this.name = name;
        this.storedAnimals = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.join(", ", this.getStoredAnimals().stream().map(Animal::getName).collect(Collectors.toList())));
        return builder.toString();
    }

    public void clearStoredAnimals() {
        this.storedAnimals = new ArrayList<>();
    }

    public void castrateAnimals() {
        this.removeUncleanedAnimals();
    }

    public String getName() {
        return name;
    }

    public List<Animal> getStoredAnimals() {
        return storedAnimals;
    }

    public void addAnimal(Animal animal) {
        this.storedAnimals.add(animal);
    }

    public void addAnimals(List<Animal> animals) {
        this.storedAnimals.addAll(animals);
    }

    public List<Animal> getUncleanedAnimals() {
        return this.storedAnimals.stream().filter(x -> x.getCleansingStatus().equals(UNCLEANED_ANIMAL_STATUS))
                .collect(Collectors.toList());
    }

    public void cleanse() {
        for (Animal storedAnimal : storedAnimals) {
            storedAnimal.setCleansingStatus(CLEANED_ANIMAL_STATUS);
        }
    }

    public void adopt() {
        this.storedAnimals.removeAll(this.getCleanedAnimals());
    }

    public List<Animal> getCleanedAnimals() {
        return this.storedAnimals.stream().filter(x -> x.getCleansingStatus().equals(CLEANED_ANIMAL_STATUS))
                .collect(Collectors.toList());
    }

    public void removeUncleanedAnimals() {
        this.storedAnimals.removeAll(this.getUncleanedAnimals());
    }


}
