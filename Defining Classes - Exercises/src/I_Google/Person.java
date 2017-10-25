package I_Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parentList;
    private List<Parent> childrenList;
    private List<Pokemon> pokemonList;

    public Person(String name, Company company, Car car) {
        this.setName(name);
        this.setCompany(company);
        this.setCar(car);
        this.parentList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\r\n");
        sb.append("Company:").append("\r\n");

        if (this.company != null) {
            sb.append(this.company).append("\r\n");
        }

        sb.append("Car:").append("\r\n");
        if (this.car != null) {
            sb.append(this.car).append("\r\n");
        }

        sb.append("Pokemon:").append("\r\n");
        if (!this.pokemonList.isEmpty()) {
            this.pokemonList.forEach(p -> sb.append(p).append("\r\n"));
        }

        sb.append("Parents:").append("\r\n");
        if (!this.parentList.isEmpty()) {
            this.parentList.forEach(p -> sb.append(p).append("\r\n"));
        }

        sb.append("Children:").append("\r\n");
        if (!this.childrenList.isEmpty()) {
            this.childrenList.forEach(c -> sb.append(c).append("\r\n"));
        }

        return sb.toString();
    }

    private String formatCarOutput(Car car) {
        return car == null ? "" : car.toString();
    }

    private String formatCompanyOutput(Company company) {
        return company == null ? "" : company.toString();
    }

    private String formatParentsOutput(List<Parent> parents) {
        StringBuilder sb = new StringBuilder();
        for (Parent parent : parents) {
            sb.append(parent);
        }
        return sb.toString();
    }

    private String formatPokemonsOutput(List<Pokemon> pokemons) {
        StringBuilder sb = new StringBuilder();
        for (Pokemon pokemon : pokemons) {
            sb.append(pokemon);
        }
        return sb.toString();
    }

    void addParent(Parent parent) {
        if (parent != null)
            this.parentList.add(parent);
    }

    void addChildren(Parent parent) {
        if (parent != null)
            this.childrenList.add(parent);
    }

    void addPokemon(Pokemon pokemon) {
        if (pokemon != null)
            this.pokemonList.add(pokemon);
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    Company getCompany() {
        return company;
    }

    void setCompany(Company company) {
        if (company != null) {
            this.company = company;
        }
    }

    Car getCar() {
        return car;
    }

    void setCar(Car car) {
        if (car != null) {
            this.car = car;
        }
    }

    List<Parent> getParentList() {
        return parentList;
    }

    void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    List<Parent> getChildrenList() {
        return childrenList;
    }

    void setChildrenList(List<Parent> childrenList) {
        this.childrenList = childrenList;
    }

    List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
