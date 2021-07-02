package OOP.EX06_ENCAPSULATION.Е05_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        if (this.players.stream().noneMatch(e -> e.getName().equals(name))) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }
        this.players.remove(this.players.stream().filter(e -> e.getName().equals(name))
                .findFirst().orElseThrow());
    }

    public double getRating() {
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }
}
