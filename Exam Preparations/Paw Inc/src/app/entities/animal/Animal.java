package app.entities.animal;

import app.entities.center.AdoptionCenter;

import static app.utilities.Constants.UNCLEANED_ANIMAL_STATUS;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Animal {
    private String name;
    private int age;
    private String cleansingStatus;

    private AdoptionCenter adoptionCenter;

    protected Animal(String name, int age, AdoptionCenter center) {
        this.name = name;
        this.age = age;
        this.cleansingStatus = UNCLEANED_ANIMAL_STATUS;
        this.adoptionCenter = center;
    }

    protected  Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.cleansingStatus = UNCLEANED_ANIMAL_STATUS;
    }

    //getters

    public AdoptionCenter getAdoptionCenter() {
        return adoptionCenter;
    }

    public String getName() {
        return name;
    }

    public String getCleansingStatus() {
        return cleansingStatus;
    }

    //setters

    public void setAdoptionCenter(AdoptionCenter adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
    }

    public void setCleansingStatus(String cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }
}
