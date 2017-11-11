package app.core;

import app.entities.animal.Animal;
import app.entities.animal.Cat;
import app.entities.animal.Dog;
import app.entities.center.AdoptionCenter;
import app.entities.center.CastrationCenter;
import app.entities.center.Center;
import app.entities.center.CleansingCenter;

import java.util.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AnimalCenterManager {
    private Map<String, AdoptionCenter> adoptionCenters;
    private Map<String, CleansingCenter> cleansingCenters;
    private Map<String, CastrationCenter> castrationCenters;

    private Set<String> adoptedAnimals;
    private Set<String> castratedAnimals;
    private Set<String> cleansedAnimals;

    public AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.castrationCenters = new HashMap<>();

        this.adoptedAnimals = new TreeSet<>();
        this.cleansedAnimals = new TreeSet<>();
        this.castratedAnimals = new TreeSet<>();
    }

    public void castrationStatistics() {
        String format = String.format("Paw Inc. Regular Castration Statistics\n" +
                        "Castration Centers: %d\n" +
                        "Castrated Animals: %s",
                this.castrationCenters.size(), getCastratedAnimalsPrintResult());
        System.out.println(format);
    }


    public void castrate(String castrationCenterName) {
        Center center = this.castrationCenters.get(castrationCenterName);

        List<Animal> storedAnimals = center.getStoredAnimals();
        for (Animal storedAnimal : storedAnimals) {
            this.adoptionCenters.get(storedAnimal.getAdoptionCenter().getName()).addAnimal(storedAnimal);
            this.castratedAnimals.add(storedAnimal.getName());
        }

        this.castrationCenters.get(castrationCenterName).clearStoredAnimals();
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        this.castrationCenters.get(castrationCenterName).addAnimals(this.adoptionCenters.get(adoptionCenterName).getUncleanedAnimals());
        this.adoptionCenters.get(adoptionCenterName).castrateAnimals();
    }

    public void registerCastrationCenter(String name) {
        this.castrationCenters.put(name, new CastrationCenter(name));
    }

    private int getAnimalsAwaitingCleansing() {
        int result = 0;
        for (Map.Entry<String, CleansingCenter> pair : this.cleansingCenters.entrySet()) {
            result += pair.getValue().getUncleanedAnimals().size();
        }
        return result;
    }

    private int getAnimalsAwaitingAdoption() {
        int result = 0;
        for (Map.Entry<String, AdoptionCenter> pair : this.adoptionCenters.entrySet()) {
            result += pair.getValue().getCleanedAnimals().size();
        }
        return result;
    }

    public void registerCleansingCenter(String name) {
        CleansingCenter center = new CleansingCenter(name);
        this.cleansingCenters.put(name, center);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter center = new AdoptionCenter(name);
        this.adoptionCenters.put(name, center);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Animal dog = new Dog(name, age, learnedCommands);
        dog.setAdoptionCenter(this.adoptionCenters.get(adoptionCenterName));
        this.adoptionCenters.get(adoptionCenterName).addAnimal(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Animal cat = new Cat(name, age, intelligenceCoefficient);
        cat.setAdoptionCenter(this.adoptionCenters.get(adoptionCenterName));
        this.adoptionCenters.get(adoptionCenterName).addAnimal(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        List<Animal> uncleanedAnimals = this.adoptionCenters.get(adoptionCenterName).getUncleanedAnimals();
        this.cleansingCenters.get(cleansingCenterName).addAnimals(uncleanedAnimals);
        this.adoptionCenters.get(adoptionCenterName).removeUncleanedAnimals();
    }

    public void cleanse(String cleansingCenterName) {
        Center center = this.cleansingCenters.get(cleansingCenterName);
        center.cleanse();

        List<Animal> storedAnimals = center.getStoredAnimals();
        for (Animal storedAnimal : storedAnimals) {
            this.adoptionCenters.get(storedAnimal.getAdoptionCenter().getName()).addAnimal(storedAnimal);
            this.cleansedAnimals.add(storedAnimal.getName());
        }

        this.cleansingCenters.get(cleansingCenterName).clearStoredAnimals();
    }

    public void adopt(String adoptionCenterName) {
        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
        adoptionCenter.getCleanedAnimals().forEach(x -> this.adoptedAnimals.add(x.getName()));
        adoptionCenter.adopt();
    }

    public void printStatistics() {
        String format = String.format("Paw Incorporative Regular Statistics\n" +
                        "Adoption Centers: %d\n" +
                        "Cleansing Centers: %d\n" +
                        "Adopted Animals: %s\n" +
                        "Cleansed Animals: %s\n" +
                        "Animals Awaiting Adoption: %d\n" +
                        "Animals Awaiting Cleansing: %d",
                this.adoptionCenters.size(), this.cleansingCenters.size(),
                getAdoptedAnimalsPrintResult(), getCleansedAnimalsPrintResult(),
                getAnimalsAwaitingAdoption(), getAnimalsAwaitingCleansing());
        System.out.println(format);
    }

    private String getAdoptedAnimalsPrintResult() {
        return this.adoptedAnimals.size() != 0 ? this.adoptedAnimals.toString().replace("[", "").replace("]", "") : "None";
    }

    private String getCleansedAnimalsPrintResult() {
        return this.cleansedAnimals.size() != 0 ? this.cleansedAnimals.toString().replace("[", "").replace("]", "") : "None";
    }

    private String getCastratedAnimalsPrintResult() {
        return this.castratedAnimals.size() != 0 ? this.castratedAnimals.toString().replace("[", "").replace("]", "") : "None";
    }
}
