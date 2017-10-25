package I_Google;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Parent {
    private String name;
    private String birthday;

    public Parent(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
    }

    @Override
    public String toString() {
        String format = String.format("%s %s", this.getName(), this.getBirthday());
        return format;
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    String getBirthday() {
        return birthday;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
