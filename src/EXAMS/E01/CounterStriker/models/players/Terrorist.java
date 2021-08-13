package EXAMS.E01.CounterStriker.models.players;

import EXAMS.E01.CounterStriker.models.guns.Gun;

public class Terrorist extends PlayerImpl {

    public Terrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }
}
