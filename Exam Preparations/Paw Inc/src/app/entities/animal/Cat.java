package app.entities.animal;

import app.entities.center.AdoptionCenter;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Cat extends Animal {
    private int intelligenceCoefficient;

    public Cat(String name, int age, int intelligenceCoefficient, AdoptionCenter center) {
        super(name, age, center);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    public Cat(String name, int age, int intelligenceCoefficient) {
        super(name, age);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }
}
