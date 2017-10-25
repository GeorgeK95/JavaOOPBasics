package I_Google;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getType() ;
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }
}
