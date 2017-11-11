package app.entities.center;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CleansingCenter extends Center {

    public CleansingCenter(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Cleansed Animals: ".concat(super.toString());
    }


}
