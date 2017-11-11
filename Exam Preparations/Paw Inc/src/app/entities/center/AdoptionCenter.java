package app.entities.center;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Adopted Animals: ".concat(super.toString());
    }
}
