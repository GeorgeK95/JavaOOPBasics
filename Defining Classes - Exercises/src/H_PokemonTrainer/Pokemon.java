package H_PokemonTrainer;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Pokemon {
    private String name;
    private String element;
    private int health;
    private boolean isDeleted = false;

    Pokemon(String name, String element, int health) {
        this.setName(name);
        this.setElement(element);
        this.setHealth(health);
    }

    boolean isDeleted() {
        return isDeleted;
    }

    void setDeleted() {
        isDeleted = true;
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    String getElement() {
        return element;
    }

    private void setElement(String element) {
        this.element = element;
    }

    int getHealth() {
        return health;
    }

    void setHealth(int health) {
        this.health = health;
    }
}
