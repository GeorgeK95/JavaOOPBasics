import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Team {
    private String name;
    private List<Person> firstTeamPlayer;
    private List<Person> reverseTeamPlayer;

    Team(String name) {
        this.setName(name);
        this.firstTeamPlayer = new ArrayList<>();
        this.reverseTeamPlayer = new ArrayList<>();
    }

    void addPlayer(Person player) {
        if (player.getAge() < 40) {
            this.firstTeamPlayer.add(player);
        } else {
            this.reverseTeamPlayer.add(player);
        }
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    List<Person> getFirstTeamPlayer() {
        return Collections.unmodifiableList(this.firstTeamPlayer);
    }

    private void setFirstTeamPlayer(List<Person> firstTeamPlayer) {
        this.firstTeamPlayer = firstTeamPlayer;
    }

    List<Person> getReverseTeamPlayer() {
        return Collections.unmodifiableList(this.reverseTeamPlayer);
    }

    private void setReverseTeamPlayer(List<Person> reverseTeamPlayer) {
        this.reverseTeamPlayer = reverseTeamPlayer;
    }
}
