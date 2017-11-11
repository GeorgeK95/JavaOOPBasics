package app.entities.animal;

import app.entities.center.AdoptionCenter;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Dog extends Animal {
    private int amountOfCommands;


    public Dog(String name, int age, int amountOfCommands, AdoptionCenter center) {
        super(name, age, center);
        this.amountOfCommands = amountOfCommands;
    }

    public Dog(String name, int age, int amountOfCommands) {
        super(name, age);
        this.amountOfCommands = amountOfCommands;
    }
}
