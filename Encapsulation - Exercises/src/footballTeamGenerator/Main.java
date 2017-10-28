package footballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Map<String, Team> teams = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if ("END".equals(line)) {
                break;
            }
            String[] data = line.split(";");
            try {
                switch (data[0]) {
                    case "Team":
                        registerTeam(data[1]);
                        break;
                    case "Add":
                        addPlayerInTeam(data);
                        break;
                    case "Remove":
                        removePlayerFromTeam(data[1], data[2]);
                        break;
                    case "Rating":
                        printTeamRatins(data[1]);
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private static void printTeamRatins(String teamName) throws IllegalArgumentException {
        if (!teams.containsKey(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
        System.out.println(teams.get(teamName));
    }

    private static void removePlayerFromTeam(String teamName, String playerName) throws IllegalArgumentException {
        teams.get(teamName).removePlayer(playerName);
    }


    private static void addPlayerInTeam(String[] data) throws IllegalArgumentException {
        String teamName = data[1];
        if (!teams.containsKey(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
        String playerName = data[2];
        int enduranceLevel = Integer.parseInt(data[3]);
        int sprinteLevel = Integer.parseInt(data[4]);
        int dribbleLevel = Integer.parseInt(data[5]);
        int passLevel = Integer.parseInt(data[6]);
        int shootLevel = Integer.parseInt(data[7]);
        try {
            Player player = new Player(playerName, enduranceLevel, sprinteLevel, dribbleLevel, passLevel, shootLevel);
            teams.get(teamName).addPlayer(player);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void registerTeam(String teamName) {
        if (!teams.containsKey(teamName)) {
            teams.put(teamName, new Team(teamName));
        }
    }
}
