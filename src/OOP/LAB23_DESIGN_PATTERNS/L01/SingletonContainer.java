package OOP.LAB23_DESIGN_PATTERNS.L01;

import java.util.HashMap;
import java.util.Map;

public class SingletonContainer {

    private SingletonContainer() {

    }

    private static PopulationTracker tracker;
    private static boolean isInitialized;

    public static PopulationTracker getTracker() {
        if(!isInitialized) {
            throw new IllegalStateException("SingletonContainer not initialized call .init() first");
        }
        return tracker;
    }


    public static void init() {
        if (!isInitialized) {
            isInitialized = true;
            tracker = PopulationTracker.getInstance();
        }
    }
}
