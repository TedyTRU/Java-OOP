package EXAMS.E04.viceCity;

import EXAMS.E04.viceCity.core.ControllerImpl;
import EXAMS.E04.viceCity.core.EngineImpl;
import EXAMS.E04.viceCity.core.interfaces.Controller;
import EXAMS.E04.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl(); // TODO
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
