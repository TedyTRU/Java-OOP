package aquarium;

import aquarium.core.Engine;
import aquarium.core.EngineImpl;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.repositories.DecorationRepository;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();

    }
}
