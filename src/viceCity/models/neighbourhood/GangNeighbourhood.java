package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {

    public GangNeighbourhood() {
    }

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        boolean allDead = false;

        for (Gun gun : mainPlayer.getGunRepository().getModels()) {
            while (gun.canFire()) {
                for (Player civilPlayer : civilPlayers) {
                    while (civilPlayer.isAlive() && gun.canFire()) {
                        civilPlayer.takeLifePoints(gun.fire());
                        if (civilPlayers.stream().noneMatch(Player::isAlive)) {
                            allDead = true;
                        }
                    }
                }
                if (allDead) {
                    break;
                }
            }
        }

        if (!allDead) {
            List<Player> alivePlayers = civilPlayers.stream().filter(Player::isAlive).collect(Collectors.toList());
            for (Player player : alivePlayers) {
                for (Gun gun : player.getGunRepository().getModels()) {
                    while (gun.canFire() && mainPlayer.isAlive()) {
                        mainPlayer.takeLifePoints(gun.fire());

                    }
                }
                if (!mainPlayer.isAlive()) {
                    break;
                }
            }
        }

    }
}
