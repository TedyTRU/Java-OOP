package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Collection;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;

        if (type.equals("Rifle")) {
            gun = new Rifle(name, bulletsCount);

        } else if (type.equals("Pistol")) {
            gun = new Pistol(name, bulletsCount);

        } else {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }

        guns.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, gun.getName());
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Player player;
        Gun gun = guns.findByName(gunName);

        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        if (type.equals("Terrorist")) {
            player = new Terrorist(username, health, armor, gun);

        } else if (type.equals("CounterTerrorist")) {
            player = new CounterTerrorist(username, health, armor, gun);

        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        players.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {

        return field.start(players.getModels());

    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        players.getModels().stream()
                .sorted((p1, p2) -> {
                    int sort = p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());

                    if (sort == 0) {
                        sort = Integer.compare(p2.getHealth(), p1.getHealth());

                        if (sort == 0) {
                            sort = p1.getUsername().compareTo(p2.getUsername());
                        }
                    }
                    return sort;
                }).forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
