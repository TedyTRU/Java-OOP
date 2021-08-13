package EXAMS.E05.spaceStation.core;

import EXAMS.E05.spaceStation.models.astronauts.Astronaut;
import EXAMS.E05.spaceStation.models.astronauts.Biologist;
import EXAMS.E05.spaceStation.models.astronauts.Geodesist;
import EXAMS.E05.spaceStation.models.astronauts.Meteorologist;
import EXAMS.E05.spaceStation.models.mission.Mission;
import EXAMS.E05.spaceStation.models.mission.MissionImpl;
import EXAMS.E05.spaceStation.models.planets.Planet;
import EXAMS.E05.spaceStation.models.planets.PlanetImpl;
import EXAMS.E05.spaceStation.repositories.AstronautRepository;
import EXAMS.E05.spaceStation.repositories.PlanetRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static EXAMS.E05.spaceStation.common.ConstantMessages.*;
import static EXAMS.E05.spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Astronaut astronaut;
    private Planet planet;
    int countExploredPlanets;
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {

        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(this.astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {

        this.planet = new PlanetImpl(planetName);
        Collection<String> planetItems = this.planet.getItems();

        Collections.addAll(planetItems, items);

        this.planetRepository.add(this.planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronautToRetire = this.astronautRepository.findByName(astronautName);

        if (astronautToRetire == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        this.astronautRepository.remove(astronautToRetire);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Mission mission = new MissionImpl();
        Planet planet = planetRepository.findByName(planetName);
        List<Astronaut> sentAstronauts = this.astronautRepository
                .getModels().stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        if (sentAstronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        int sentAstronautsCount = sentAstronauts.size();
        mission.explore(planet, sentAstronauts);
        countExploredPlanets++;
        int returnedAstronautsCount = sentAstronauts.size();

        return String.format(PLANET_EXPLORED, planetName, (sentAstronautsCount - returnedAstronautsCount));
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, countExploredPlanets)).append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());

        astronautRepository.getModels().forEach(astr -> {
            sb.append(String.format(REPORT_ASTRONAUT_NAME, astr.getName())).append(System.lineSeparator());
            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, astr.getOxygen())).append(System.lineSeparator());

            if (astr.getBag().getItems().isEmpty()) {
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());

            } else {
                Collection<String> items = astr.getBag().getItems();
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, String.join(", ", items))).append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }
}
