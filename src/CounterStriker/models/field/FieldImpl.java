package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.*;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {

        List<Player> terrorists = players.stream()
                .filter(p -> p instanceof Terrorist)
                .collect(Collectors.toList());

        List<Player> counterTerrorists = players.stream()
                .filter(p -> p instanceof CounterTerrorist)
                .collect(Collectors.toList());

        while (terrorists.stream().allMatch(Player::isAlive) &&
                counterTerrorists.stream().allMatch(Player::isAlive)) {

            terrorists.stream().filter(Player::isAlive)
                    .<Consumer<? super Player>>
                            map(terrorist -> player -> player.takeDamage(terrorist.getGun().fire()))
                    .forEach(counterTerrorists::forEach);

            counterTerrorists.stream().filter(Player::isAlive)
                    .<Consumer<? super Player>>
                            map(counterTerrorist -> player -> player.takeDamage(counterTerrorist.getGun().fire()))
                    .forEach(terrorists::forEach);
        }

        return terrorists.stream().anyMatch(Player::isAlive) ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;
    }
}
