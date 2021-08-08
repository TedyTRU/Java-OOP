package CounterStriker;

import CounterStriker.core.Engine;
import CounterStriker.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
