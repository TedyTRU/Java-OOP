package EXAMS.E04.viceCity.core;

import EXAMS.E04.viceCity.core.interfaces.Controller;
import EXAMS.E04.viceCity.models.guns.*;
import EXAMS.E04.viceCity.models.neighbourhood.GangNeighbourhood;
import EXAMS.E04.viceCity.models.neighbourhood.Neighbourhood;
import EXAMS.E04.viceCity.models.players.*;

import java.util.*;
import java.util.stream.Collectors;

import static EXAMS.E04.viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Map<String, Player> civilPlayers;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        this.civilPlayers.putIfAbsent(name, new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        if (type.equals("Rifle")) {
            gun = new Rifle(name);

        } else if (type.equals("Pistol")) {
            gun = new Pistol(name);

        } else {
            return GUN_TYPE_INVALID;

        }
        guns.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = guns.poll();
        if (gun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }

        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER,
                    gun.getName(), mainPlayer.getName());
        }

        Player player = civilPlayers.get(name);
        if (player == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        player.getGunRepository().add(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(),
                player.getName());
    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, civilPlayers.values());

        if (mainPlayer.getLifePoints() == 100 &&
                civilPlayers.values().stream().allMatch(p -> p.getLifePoints() == 50)) {
            return FIGHT_HOT_HAPPENED;
        }


//         List<Player> alivePlayers = civilPlayers.values()
//                .stream()
//                .filter(Player::isAlive)
//                .collect(Collectors.toList());

        List<Player> deadPlayers = civilPlayers.values()
                .stream()
                .filter(p -> !p.isAlive())
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder(FIGHT_HAPPENED)
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()))
                .append(System.lineSeparator())
                .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size() - deadPlayers.size()));

        for (Player deadPlayer : deadPlayers) {
            civilPlayers.remove(deadPlayer.getName());
        }

        return sb.toString().trim();
    }
}
