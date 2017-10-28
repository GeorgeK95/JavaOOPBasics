package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Team {
    private String name;
    private List<Player> players;

    Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public double getTeamRating() {
        return this.getPlayers().stream().mapToDouble(Player::getOverallSkillLevel).average().orElse(0);
    }

    private List<Player> getPlayers() {
        return players;
    }

    public void removePlayer(String playerName) {
        Player foundPlayer = this.players.stream().filter(x -> x.getName().equals(playerName)).findAny().orElse(null);
        if (foundPlayer == null) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.getName()));
        }
        this.players.remove(foundPlayer);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f", this.getName(), this.getTeamRating());
    }
}
