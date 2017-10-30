package stackOfStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class StackOfStrings {
    private List<String> data = new ArrayList<>();

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        String taken = this.data.get(data.size() - 1);
        this.data.remove(data.size() - 1);
        return taken;
    }

    public String peek() {
        return this.data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.size() == 0;
    }
}
