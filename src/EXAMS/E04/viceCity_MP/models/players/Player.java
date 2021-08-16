package EXAMS.E04.viceCity_MP.models.players;

import EXAMS.E04.viceCity_MP.models.guns.Gun;
import EXAMS.E04.viceCity_MP.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
