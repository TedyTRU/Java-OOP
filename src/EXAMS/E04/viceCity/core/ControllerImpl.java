package EXAMS.E04.viceCity.core;

import EXAMS.E04.viceCity.models.guns.Gun;
import EXAMS.E04.viceCity.models.guns.Pistol;
import EXAMS.E04.viceCity.models.guns.Rifle;
import EXAMS.E04.viceCity.models.neighbourhood.GangNeighbourhood;
import EXAMS.E04.viceCity.models.neighbourhood.Neighbourhood;
import EXAMS.E04.viceCity.models.players.CivilPlayer;
import EXAMS.E04.viceCity.models.players.MainPlayer;
import EXAMS.E04.viceCity.models.players.Player;
import EXAMS.E04.viceCity.core.interfaces.Controller;

import java.util.*;

import static EXAMS.E04.viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private MainPlayer mainPlayer;
    private Collection<Player> civilPlayers;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        //CivilPlayer player = new CivilPlayer(name);
        this.civilPlayers.add(new CivilPlayer(name));

        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Rifle":
                gun = new Rifle(name);
                break;
            case "Pistol":
                gun = new Pistol(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }

        guns.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = guns.peek();
        if (gun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }

        Player player = this.civilPlayers.stream()
                .filter(p -> p.getName().equals(name))
                .findAny().orElse(null);

        if (name.equals("Vercetti")) {
            this.mainPlayer.getGunRepository().add(guns.poll());
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), this.mainPlayer.getName());

        } else if (player == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;

        } else {
            player.getGunRepository().add(guns.poll());
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);

        }
    }

    @Override
    public String fight() {
        int initialCount = this.civilPlayers.size();
        this.neighbourhood.action(this.mainPlayer, this.civilPlayers);
        long aliveCount = this.civilPlayers.stream().filter(Player::isAlive).count();
        long deadCount = initialCount - aliveCount;

        if (this.mainPlayer.isAlive() && this.civilPlayers.stream().allMatch(Player::isAlive)) {
            return FIGHT_HOT_HAPPENED;

        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(FIGHT_HAPPENED)
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, this.mainPlayer.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCount))
                    .append(System.lineSeparator())
                    .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, aliveCount));

            return sb.toString().trim();
        }
    }
}
