package H_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    private static HashSet<String> trainerNames = new HashSet<>();
    private static List<Trainer> trainerList = new ArrayList<>();

    public static void main(String[] args) {
        readPokemons();
        readElements();
        print();
    }

    private static void print() {
        Comparator<? super Trainer> comp = (Comparator<Trainer>) (o1, o2) -> Integer.compare(o2.getBadges(), o1.getBadges());
        trainerList = trainerList.stream().sorted(comp).collect(Collectors.toList());
        for (Trainer trainer : trainerList) {
            System.out.printf("%s %d %d%n", trainer.getName(), trainer.getBadges(), trainer.getPokemonList().stream()
                    .filter(x -> !x.isDeleted()).collect(Collectors.toList()).size());
        }
    }

    private static void readElements() {
        while (true) {
            String element = in.nextLine();
            if ("End".equals(element)) {
                break;
            }
            checkTrainers(element);
        }
    }

    private static void checkTrainers(String element) {
        for (Trainer trainer : trainerList) {
            Optional<Pokemon> pokemon = trainer.getPokemonList().stream().filter(x -> !x.isDeleted()).filter(x -> x.getElement().equals(element)).findAny();
            if (pokemon.isPresent()) {
                trainer.setBadges(trainer.getBadges() + 1);
            } else {
                for (Pokemon currentPokemon : trainer.getPokemonList()) {
                    currentPokemon.setHealth(currentPokemon.getHealth() - 10);
                    if (currentPokemon.getHealth() <= 0) {
                        currentPokemon.setDeleted();
                    }
                }
            }
        }
    }

    private static void readPokemons() {
        while (true) {
            String line = in.nextLine();
            if ("Tournament".equals(line)) {
                break;
            }
            String[] data = line.split("\\s+");
            String trainer = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);

            writeData(trainer, pokemonName, element, health);
        }
    }

    private static void writeData(String trainerName, String pokemonName, String element, int health) {
        Pokemon pokemon = new Pokemon(pokemonName, element, health);
        if (!trainerNames.contains(trainerName)) {
            List<Pokemon> pokemonList = new ArrayList<>();
            pokemonList.add(pokemon);
            Trainer trainer = new Trainer(trainerName, pokemonList);
            trainerList.add(trainer);
            trainerNames.add(trainerName);
        } else {
            trainerList.stream().filter(x -> x.getName().equals(trainerName)).findFirst()
                    .get().getPokemonList().add(pokemon);

           /* Trainer found = getTrainerByName(trainerName);
            found.getPokemonList().add(pokemon);*/
        }
    }
}
