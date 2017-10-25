package H_PokemonTrainer;

import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Trainer {
    private String name;
    private int badges = 0;
    private List<Pokemon> pokemonList;

    Trainer(String name, List<Pokemon> pokemonList) {
        this.setName(name);
        this.setPokemonList(pokemonList);
    }

    String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }

    int getBadges() {
        return badges;
    }

     void setBadges(int badges) {
        this.badges = badges;
    }

    List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    private void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
