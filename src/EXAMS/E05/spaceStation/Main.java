package EXAMS.E05.spaceStation;

import EXAMS.E05.spaceStation.core.Controller;
import EXAMS.E05.spaceStation.core.ControllerImpl;
import EXAMS.E05.spaceStation.core.Engine;
import EXAMS.E05.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
