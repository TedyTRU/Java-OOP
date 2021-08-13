package EXAMS.E05.spaceStation.models.mission;

import EXAMS.E05.spaceStation.models.astronauts.Astronaut;
import EXAMS.E05.spaceStation.models.planets.Planet;

import java.util.List;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, List<Astronaut> astronauts) {


//        for (int i = 0; i < astronauts.size(); i++) {
//                Astronaut astronaut = astronauts.get(0);
//                if (astronaut.canBreath()) {
//                    while (!planet.getItems().isEmpty()) {
//                        String currentItem = planet.getItems().get(0);
//
//                        if (astronaut.canBreath()) {
//                            astronaut.getBag().getItems().add(currentItem);
//                            planet.getItems().remove(currentItem);
//                            astronaut.breath();
//
//                        } else {
//
//                            astronauts.remove(astronaut);
//                            break;
//                        }
//                    }
//                }
//            }

                for (int i = 0; i < astronauts.size(); i++) {
                Astronaut astronaut = astronauts.get(i);

                for (int j = 0; j < planet.getItems().size(); j++) {
                    String currentItem = planet.getItems().get(j);
                    astronaut.getBag().getItems().add(currentItem);
                    planet.getItems().remove(currentItem);
                    j--;
                    astronaut.breath();

                    if (!astronaut.canBreath()) {
                        astronauts.remove(astronaut);
                        i--;
                        break;
                    }
                }
            }


    }
}
