package J_FamilyTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Person {
    private String name;
    private String date;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String date) {
        this.setName(name);
        this.setDate(date);
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName() + " " + this.getDate());
        sb.append(System.getProperty("line.separator"));
        sb.append("Parents:");
        sb.append(System.getProperty("line.separator"));
        for (Person parent : this.parents) {
            sb.append(parent.getName() + " " + parent.getDate());
            sb.append(System.getProperty("line.separator"));
        }
        sb.append("Children:");
        sb.append(System.getProperty("line.separator"));
        for (Person child : this.children) {
            sb.append(child.getName() + " " + child.getDate());
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    void addChild(Person child) {
        this.children.add(child);
    }

    void addParent(Person parent) {
        this.parents.add(parent);
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    String getDate() {
        return date;
    }

    private void setDate(String date) {
        this.date = date;
    }

    List<Person> getParents() {
        return parents;
    }

    private void setParents(List<Person> parents) {
        this.parents = parents;
    }

    List<Person> getChildren() {
        return children;
    }

    private void setChildren(List<Person> children) {
        this.children = children;
    }
}
