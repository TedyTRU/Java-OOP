package EXAMS.E02.onlineShop;

import EXAMS.E02.onlineShop.core.EngineImpl;
import EXAMS.E02.onlineShop.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
