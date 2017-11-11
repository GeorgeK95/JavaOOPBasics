package app.entities.monument;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class Monument {
    private String name;

    Monument(String name) {
        this.setName(name);
    }

    public abstract int getAffinity();

    @Override
    public abstract String toString();

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
