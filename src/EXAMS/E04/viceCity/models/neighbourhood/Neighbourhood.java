package EXAMS.E04.viceCity.models.neighbourhood;

import EXAMS.E04.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, Collection<Player> civilPlayers);
}
