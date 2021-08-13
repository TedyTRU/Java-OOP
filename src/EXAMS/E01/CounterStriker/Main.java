package EXAMS.E01.CounterStriker;

import EXAMS.E01.CounterStriker.core.Engine;
import EXAMS.E01.CounterStriker.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
