package mordorsCrueltyPlan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Wizard {
    private Map<String, Integer> foodPoints;
    private int points;

    public Wizard() {
        initialiseData();
    }

    private void initialiseData() {
        this.foodPoints = new HashMap<>();
        this.foodPoints.put("cram", 2);
        this.foodPoints.put("lembas", 3);
        this.foodPoints.put("apple", 1);
        this.foodPoints.put("melon", 1);
        this.foodPoints.put("honeycake", 5);
        this.foodPoints.put("mushrooms", -10);
    }

    private void eat(String food) {
        if (!this.foodPoints.containsKey(food)) {
            points--;
        } else {
            points += this.foodPoints.get(food);
        }
    }

    void eatAll(String[] food) {
        for (String current : food) {
            this.eat(current.toLowerCase());
        }
    }

    int getPoints() {
        return points;
    }

    private void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        if (this.points < -5) {
            return "Angry";
        } else if (this.points >= -5 && this.points < 0) {
            return "Sad";
        } else if (this.points >= 0 && this.points < 15) {
            return "Happy";
        } else {
            return "JavaScript";
        }
    }
}
