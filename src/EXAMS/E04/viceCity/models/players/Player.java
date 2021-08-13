package EXAMS.E04.viceCity.models.players;

import EXAMS.E04.viceCity.models.guns.Gun;
import EXAMS.E04.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
