package randomArrayList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RandomArrayList extends ArrayList {

    public Object getRandomElement() {
        int index = this.generateRandomIndex(super.size());
        return super.get(index);
    }

    private int generateRandomIndex(int size) {
        Random rand = new Random();
        return rand.nextInt(size);
    }
}