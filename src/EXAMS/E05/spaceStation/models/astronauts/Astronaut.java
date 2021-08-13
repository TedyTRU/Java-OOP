package EXAMS.E05.spaceStation.models.astronauts;

import EXAMS.E05.spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
