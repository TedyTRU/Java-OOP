package EXAMS.E04.viceCity_MP;

import EXAMS.E04.viceCity_MP.core.ControllerImpl;
import EXAMS.E04.viceCity_MP.core.EngineImpl;
import EXAMS.E04.viceCity_MP.core.interfaces.Controller;
import EXAMS.E04.viceCity_MP.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
