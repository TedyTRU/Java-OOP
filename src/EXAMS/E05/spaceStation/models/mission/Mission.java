package EXAMS.E05.spaceStation.models.mission;

import EXAMS.E05.spaceStation.models.astronauts.Astronaut;
import EXAMS.E05.spaceStation.models.planets.Planet;

import java.util.List;

public interface Mission {
    void explore(Planet planet, List<Astronaut> astronauts);
}
