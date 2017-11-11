package app.factories;

import app.entities.animal.Cat;
import app.entities.animal.Dog;
import app.entities.center.AdoptionCenter;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public final class AnimalFactory {
    public static Dog generateDog(String name, int age, int commands, AdoptionCenter adoptionCenter) {
        return new Dog(name, age, commands,adoptionCenter);
    }

    public static Cat generateCat(String name, int age, int coefficient, AdoptionCenter adoptionCenter) {
        return new Cat(name, age, coefficient,adoptionCenter);
    }
}
