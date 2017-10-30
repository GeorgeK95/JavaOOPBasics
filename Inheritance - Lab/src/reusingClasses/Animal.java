package reusingClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Animal {
    protected List<Food> foodEaten = new ArrayList<>();

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] food) {
        for (Food current : food) {
            this.eat(current);
        }
    }
}
