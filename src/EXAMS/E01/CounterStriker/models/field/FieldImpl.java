package EXAMS.E01.CounterStriker.models.field;

import EXAMS.E01.CounterStriker.models.players.CounterTerrorist;
import EXAMS.E01.CounterStriker.models.players.Player;
import EXAMS.E01.CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static EXAMS.E01.CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static EXAMS.E01.CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {

    public FieldImpl() {
    }

    @Override
    public String start(Collection<Player> players) {

        List<Player> terrorists = players.stream().filter(p -> p instanceof Terrorist).collect(Collectors.toList());
        List<Player> counterTerrorists = players.stream().filter(p -> p instanceof CounterTerrorist).collect(Collectors.toList());

        while (terrorists.stream().anyMatch(Player::isAlive) && counterTerrorists.stream().anyMatch(Player::isAlive)) {
            battle(counterTerrorists, terrorists);
            battle(terrorists, counterTerrorists);

        }

        return terrorists.stream().anyMatch(Player::isAlive) ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;
    }

    private void battle(List<Player> terrorists, List<Player> counterTerrorists) {
        for (Player counterTerrorist : counterTerrorists) {
            for (Player terrorist : terrorists) {
                if (counterTerrorist.isAlive() && terrorist.isAlive()) {
                    terrorist.takeDamage(counterTerrorist.getGun().fire());
                }
            }
        }
    }
}
