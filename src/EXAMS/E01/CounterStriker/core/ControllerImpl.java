package EXAMS.E01.CounterStriker.core;

import EXAMS.E01.CounterStriker.models.field.Field;
import EXAMS.E01.CounterStriker.models.field.FieldImpl;
import EXAMS.E01.CounterStriker.models.guns.Gun;
import EXAMS.E01.CounterStriker.models.guns.Pistol;
import EXAMS.E01.CounterStriker.models.guns.Rifle;
import EXAMS.E01.CounterStriker.models.players.CounterTerrorist;
import EXAMS.E01.CounterStriker.models.players.Player;
import EXAMS.E01.CounterStriker.models.players.Terrorist;
import EXAMS.E01.CounterStriker.repositories.GunRepository;
import EXAMS.E01.CounterStriker.repositories.PlayerRepository;

import java.util.Comparator;
import java.util.stream.Collectors;

import static EXAMS.E01.CounterStriker.common.ExceptionMessages.*;
import static EXAMS.E01.CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static EXAMS.E01.CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    private Gun gun;
    private Player player;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {

        switch (type) {
            case "Pistol":
                this.gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                this.gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        this.guns.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        this.gun = this.guns.findByName(gunName);
        if (this.gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        switch (type) {
            case "Terrorist":
                this.player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                this.player = new CounterTerrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        this.players.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return this.field.start(this.players.getModels());
    }

    @Override
    public String report() {

        return this.players.getModels().stream()
                .sorted(Comparator.comparing(Player::getUsername))
                .sorted(Comparator.comparing(Player::getHealth).reversed())
                .sorted(Comparator.comparing(p -> p.getClass().getSimpleName()))
                .map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator()));

    }
//
//    Comparator<Player> compareByHealthAndName = Comparator.comparing(Player::getHealth).reversed().thenComparing(Player::getUsername);
//
//        Collections.sort(ct,compareByHealthAndName);
//        Collections.sort(t,compareByHealthAndName);
}
