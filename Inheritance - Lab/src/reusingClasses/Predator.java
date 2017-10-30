package reusingClasses;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Predator extends Animal {
    private int health;

    public void feed(Food food) {
        super.eat(food);
    }
}
