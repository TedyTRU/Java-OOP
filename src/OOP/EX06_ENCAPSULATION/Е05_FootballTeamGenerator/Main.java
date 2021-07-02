package OOP.EX06_ENCAPSULATION.Е05_FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Team> teams = new HashMap<>();

        while (!"END".equals(command)) {
            String[] tokens = command.split(";");
            String name = tokens[1];

            switch (tokens[0]) {
                case "Team":
                    addTeam(teams, name);
                    break;

                case "Add":
                    addPlayer(teams, tokens, name);
                    break;

                case "Remove":
                    removePlayer(teams, tokens, name);
                    break;

                case "Rating":
                    printRating(teams, name);
                    break;
            }

            command = scanner.nextLine();
        }

    }

    private static void printRating(Map<String, Team> teams, String name) {
        if (!teams.containsKey(name)) {
            System.out.printf("Team %s does not exist.%n", name);
        } else {
            System.out.printf("%s - %.0f%n", name, teams.get(name).getRating());
        }
    }

    private static void removePlayer(Map<String, Team> teams, String[] tokens, String name) {
        if (!teams.containsKey(name)) {
            System.out.printf("Player %s is not in %s team.%n", tokens[2], name);
        } else {
            try {
                teams.get(name).removePlayer(tokens[2]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addTeam(Map<String, Team> teams, String name) {
        try {
            Team team = new Team(name);
            teams.putIfAbsent(name, team);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addPlayer(Map<String, Team> teams, String[] tokens, String name) {
        if (!teams.containsKey(name)) {
            System.out.printf("Team %s does not exist.%n", name);
        } else {
            try {
                Player player = new Player(tokens[2],
                        Integer.parseInt(tokens[3]),
                        Integer.parseInt(tokens[4]),
                        Integer.parseInt(tokens[5]),
                        Integer.parseInt(tokens[6]),
                        Integer.parseInt(tokens[7]));
                teams.get(name).addPlayer(player);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

